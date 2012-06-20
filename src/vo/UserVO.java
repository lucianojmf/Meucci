package vo;

public class UserVO extends ObjectVO {

    private String name;

    public UserVO() {
    }

    public UserVO(String name) {
        this.name = name;
    }

    public UserVO(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
