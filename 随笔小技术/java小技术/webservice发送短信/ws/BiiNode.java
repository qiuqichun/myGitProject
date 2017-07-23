
package cn.boc.sh.sfjh.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for biiNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="biiNode">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.bocsh.com/}baseDomain">
 *       &lt;sequence>
 *         &lt;element name="items" type="{http://ws.bocsh.com/}biiNode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "biiNode", propOrder = {
    "items",
    "lan",
    "name"
})
public class BiiNode
    extends BaseDomain
{

    @XmlElement(nillable = true)
    protected List<BiiNode> items;
    protected String lan;
    protected String name;

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BiiNode }
     * 
     * 
     */
    public List<BiiNode> getItems() {
        if (items == null) {
            items = new ArrayList<BiiNode>();
        }
        return this.items;
    }

    /**
     * Gets the value of the lan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLan() {
        return lan;
    }

    /**
     * Sets the value of the lan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLan(String value) {
        this.lan = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
