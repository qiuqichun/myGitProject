
package cn.boc.sh.sfjh.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for querySubBranchList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="querySubBranchList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="branchNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgBankNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "querySubBranchList", propOrder = {
    "branchNo",
    "orgBankNo"
})
public class QuerySubBranchList {

    protected String branchNo;
    protected String orgBankNo;

    /**
     * Gets the value of the branchNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchNo() {
        return branchNo;
    }

    /**
     * Sets the value of the branchNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchNo(String value) {
        this.branchNo = value;
    }

    /**
     * Gets the value of the orgBankNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgBankNo() {
        return orgBankNo;
    }

    /**
     * Sets the value of the orgBankNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgBankNo(String value) {
        this.orgBankNo = value;
    }

}
