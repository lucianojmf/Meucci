/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author luciano
 */
public class NumberCalledVO extends ObjectVO {
    private String date;
    private String time;
    private String number;
    private float price;
    private UserVO owner;
    private boolean publicCall;
    private boolean rates;
    
    //CONSTRUTORES -------------------------------------------------------------
    public NumberCalledVO() {
        this.owner = null;
        this.rates = false;
        this.publicCall = false;
    }

    public NumberCalledVO(String date, String time, String number, float price, UserVO owner, boolean publicCall, boolean rates) {
        this.date = date;
        this.time = time;
        this.number = number;
        this.price = price;
        this.owner = owner;
        this.publicCall = publicCall;
        this.rates = rates;
    }
    
    //MÉTODOS ------------------------------------------------------------------
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserVO getOwner() {
        return owner;
    }

    public void setOwner(UserVO owner) {
        this.owner = owner;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPublicCall() {
        return publicCall;
    }

    public void setPublicCall(boolean publicCall) {
        this.publicCall = publicCall;
    }

    public boolean isRates() {
        return rates;
    }

    public void setRates(boolean rates) {
        this.rates = rates;
    }
    
    
    
}
