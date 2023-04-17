package ry.designpatterns.functionalGoF;

import org.apache.commons.lang3.Validate;

/**
 * Candidate contact information.
 *
 * @author John Psoroulas
 */
public class ContactInfo {

	private String contact;

	private boolean email;

	public ContactInfo(String contact, boolean email) {
		Validate.notBlank("Undefined contact!");
		this.contact = contact;
		this.email = email;
	}

	public ContactInfo(String contact) {
		this(contact, true);
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isEmail() {
		return email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
				.append("ContactInfo [contact=")
				.append(contact)
				.append(", email=")
				.append(email)
				.append("]");
		return builder.toString();
	}

}
