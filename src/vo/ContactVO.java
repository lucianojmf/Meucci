package vo;

public class ContactVO extends ObjectVO {

    private int user_id;
    private String name;
    private String phone;
    private String cellphone;

    public ContactVO() {
    }

    public ContactVO(String name, String phone, String cellphone) {
        this.name = name;
        this.phone = phone;
        this.cellphone = cellphone;
    }

    public ContactVO(int id, int user_id, String name, String phone, String cellphone) {
        super(id);
        this.user_id = user_id;
        this.name = name;
        this.phone = phone;
        this.cellphone = cellphone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        buffer.append("id = ");
        buffer.append(this.getId());
        buffer.append(", login = ");
        //buffer.append(this.getLogin());
        buffer.append("]");
        return buffer.toString();
    }
}
