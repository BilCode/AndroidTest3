package learn.b.btest;

import java.util.List;

/**
 * Created by Bilal on 023, 23-March-18.
 */

public class ExpandableLVModel {

    private String groupName;
    private int id;
    private List<String> childs;
    private int type;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getChilds() {
        return childs;
    }

    public void setChilds(List<String> childs) {
        this.childs = childs;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
