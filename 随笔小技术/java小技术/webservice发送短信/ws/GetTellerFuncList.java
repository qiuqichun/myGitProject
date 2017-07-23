
package cn.boc.sh.sfjh.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTellerFuncList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTellerFuncList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "getTellerFuncList", propOrder = {
    "tellerid"
})
public class GetTellerFuncList {

    protected String tellerid;

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
