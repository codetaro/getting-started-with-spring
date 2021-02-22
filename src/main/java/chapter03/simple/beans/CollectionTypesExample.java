package chapter03.simple.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class CollectionTypesExample {
    private List listType;
    private Set setType;
    private Map mapType;

    public List getListType() {
        return listType;
    }

    public void setListType(List listType) {
        this.listType = listType;
    }

    public Set getSetType() {
        return setType;
    }

    public void setSetType(Set setType) {
        this.setType = setType;
    }

    public Map getMapType() {
        return mapType;
    }

    public void setMapType(Map mapType) {
        this.mapType = mapType;
    }

    @Override
    public String toString() {
        return "CollectionTypesExample [listType=" + listType.getClass()
                + ", setType=" + setType.getClass()
                + ", mapType=" + mapType.getClass() + "]";
    }
}
