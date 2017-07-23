
package cn.boc.sh.sfjh.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for changeTellerPass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="changeTellerPass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldpassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newpassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tellerid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changeTellerPass", propOrder = {
    "oldpassword",
    "newpassword",
    "tellerid"
})
public class ChangeTellerPass {

    protected String oldpassword;
    protected String newpassword;
    protected String tellerid;

    /**
     * Gets the value of the oldpassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldpassword() {
        return oldpassword;
    }

    /**
     * Sets the value of the oldpassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldpassword(String value) {
        this.oldpassword = value;
    }

    /**
     * Gets the value of the newpassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewpassword() {
        return newpassword;
    }

    /**
     * Sets the value of the newpassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewpassword(String value) {
        this.newpassword = value;
    }

    /**
     * Gets the value of the tellerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTellerid() {
        return tellerid;
    }

    /**
     * Sets the value of the tellerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTellerid(String value) {
        this.tellerid = value;
    }

}
