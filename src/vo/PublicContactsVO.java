package vo;

public class PublicContactsVO extends ObjectVO {

    private String name;
    private String phone;
    private String cellphone;

    public PublicContactsVO() {
    }

    public PublicContactsVO(String name, String phone, String cellphone) {
        this.name = name;
        this.phone = phone;
        this.cellphone = cellphone;
    }

    public PublicContactsVO(int id, String name, String phone, String cellphone) {
        super(id);
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
