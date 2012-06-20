package business;

import business.impl.*;
import business.spec.*;


public class BusinessFactory {

	private static BusinessFactory instance = null;

	private BusinessFactory() {
	}

	public static BusinessFactory getInstance() {
		if (instance == null) {
			instance = new BusinessFactory();
		}
		return instance;
	}
	public IAdmin getAdmin() {
		return new Admin();
	}
        
        public IUser getUser() {
		return new User();
	}
        
        public IContact getContact() {
		return new Contact();
	}
        
        public IPublicContacts getPublicContact() {
		return new PublicContacts();
	}
        
        public IFatura getFatura() {
		return new Fatura();
	}
}
