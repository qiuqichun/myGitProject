
package cn.boc.sh.sfjh.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPinyin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPinyin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hanzi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPinyin", propOrder = {
    "hanzi"
})
public class GetPinyin {

    protected String hanzi;

    /**
     * Gets the value of the hanzi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHanzi() {
        return hanzi;
    }

    /**
     * Sets the value of the hanzi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHanzi(String value) {
        this.hanzi = value;
    }

}
