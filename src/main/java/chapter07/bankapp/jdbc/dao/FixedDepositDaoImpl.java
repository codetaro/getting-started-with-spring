package chapter07.bankapp.jdbc.dao;

import chapter07.bankapp.jdbc.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository(value = "fixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int createFixedDeposit(final FixedDepositDetails fdd) {
        final String sql =
                "insert into fixed_deposit_details(account_id, fd_creation_date, amount, tenure, active) " +
                "values (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"fixed_deposit_id"});
                ps.setInt(1, fdd.getBankAccountId());
                ps.setDate(2, new java.sql.Date(fdd.getFdCreationDate().getTime()));
                ps.setInt(3, fdd.getFdAmount());
                ps.setInt(4, fdd.getTenure());
                ps.setString(5, fdd.getActive());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public FixedDepositDetails getFixedDeposit(final int fixedDepositId) {
        final String sql =
                "select * from fixed_deposit_details where fixed_deposit_id = :fixedDepositId";
        SqlParameterSource namedParameters = new MapSqlParameterSource(
                "fixedDepositId", fixedDepositId);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters,
                new RowMapper<FixedDepositDetails>() {
                    @Override
                    public FixedDepositDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                        FixedDepositDetails fdd = new FixedDepositDetails();
                        fdd.setActive(resultSet.getString("active"));
                        fdd.setBankAccountId(resultSet.getInt("account_id"));
                        fdd.setFdAmount(resultSet.getInt("amount"));
                        fdd.setFdCreationDate(resultSet.getDate("fd_creation_date"));
                        fdd.setFixedDepositId(resultSet.getInt("fixed_deposit_id"));
                        fdd.setTenure(resultSet.getInt("tenure"));
                        return fdd;
                    }
                });
    }
}
