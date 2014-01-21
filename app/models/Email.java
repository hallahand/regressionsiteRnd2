package models;
/*
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;
*/

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;

import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


/* Email entity 
 * managed by ebean
 * Format should be in it's own table...or in a formats string
 */
@Entity
@Table(name="email")
public class Email extends Model {

	@Column(name="Email_ID")
    @Id
	@GeneratedValue
    public Long id;
	
	@Column(name="Email_address")
//    @Constraints.Required
    public String address;
	
	@Column(name="Format")
//    @Constraints.Required
    public String format;
	
	public Email(String address, String format)	{
		this.address = address;
		this.format = format;
		this.id = -1L;
	}
	
	public void setFormat(String fmt)	{
		this.format = fmt;
	}

    /**
     * Generic query helper for entity Bug with id Long
     */
    public static Finder<String,Email> find = new Finder<String,Email>(String.class, Email.class); 
  
	/**
	 * Returns the email object of given email address
	 * @param bug Which bug id to return
	 * @return bug with supplied id
	 */
	public static Email getEmailFromAddress(String addr)	{
		Email email = find.where()
						.eq("address",addr)
						.findUnique();
		return email;
	}
	
	/**
	 * Returns all email entries
	 */
	public static List<Email> getAllEmails()	{
	
		return find.all();
	}	
	public static List<Email> getEmailsFromFormat(String fmt)	{
	//	fmt = "%" + fmt + "%";
		List<Email> eAddresses = find.where()
					.ilike("format", fmt)
					.findList();
		return eAddresses;
				
	}
	public String toString()	{
		return ("id:" +this.id + " address:" + this.address + " format:" + this.format);
	}
}
