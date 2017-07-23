
package cn.boc.sh.sfjh.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.boc.sh.sfjh.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ChangeTellerPass_QNAME = new QName("http://ws.bocsh.com/", "changeTellerPass");
    private final static QName _QuerySubBranchList_QNAME = new QName("http://ws.bocsh.com/", "querySubBranchList");
    private final static QName _GetPinyinResponse_QNAME = new QName("http://ws.bocsh.com/", "getPinyinResponse");
    private final static QName _IsWorkingDate_QNAME = new QName("http://ws.bocsh.com/", "isWorkingDate");
    private final static QName _ChangeTellerPassResponse_QNAME = new QName("http://ws.bocsh.com/", "changeTellerPassResponse");
    private final static QName _PivsCheckResponse_QNAME = new QName("http://ws.bocsh.com/", "pivsCheckResponse");
    private final static QName _GetBranchResponse_QNAME = new QName("http://ws.bocsh.com/", "getBranchResponse");
    private final static QName _GetBIIFuncionTree_QNAME = new QName("http://ws.bocsh.com/", "getBIIFuncionTree");
    private final static QName _ValidateUserResponse_QNAME = new QName("http://ws.bocsh.com/", "validateUserResponse");
    private final static QName _SendNotesResponse_QNAME = new QName("http://ws.bocsh.com/", "sendNotesResponse");
    private final static QName _GetTellerFuncListResponse_QNAME = new QName("http://ws.bocsh.com/", "getTellerFuncListResponse");
    private final static QName _GetTeller_QNAME = new QName("http://ws.bocsh.com/", "getTeller");
    private final static QName _GetSubBranchList_QNAME = new QName("http://ws.bocsh.com/", "getSubBranchList");
    private final static QName _SendSmsResponse_QNAME = new QName("http://ws.bocsh.com/", "sendSmsResponse");
    private final static QName _GetTellerFuncList_QNAME = new QName("http://ws.bocsh.com/", "getTellerFuncList");
    private final static QName _GetPinyin_QNAME = new QName("http://ws.bocsh.com/", "getPinyin");
    private final static QName _GetSubBranchListResponse_QNAME = new QName("http://ws.bocsh.com/", "getSubBranchListResponse");
    private final static QName _ValidateUser_QNAME = new QName("http://ws.bocsh.com/", "validateUser");
    private final static QName _Exception_QNAME = new QName("http://ws.bocsh.com/", "Exception");
    private final static QName _GetBIIFuncionTreeResponse_QNAME = new QName("http://ws.bocsh.com/", "getBIIFuncionTreeResponse");
    private final static QName _SendMailResponse_QNAME = new QName("http://ws.bocsh.com/", "sendMailResponse");
    private final static QName _IOException_QNAME = new QName("http://ws.bocsh.com/", "IOException");
    private final static QName _PivsCheck_QNAME = new QName("http://ws.bocsh.com/", "pivsCheck");
    private final static QName _GetBranch_QNAME = new QName("http://ws.bocsh.com/", "getBranch");
    private final static QName _IsWorkingDateResponse_QNAME = new QName("http://ws.bocsh.com/", "isWorkingDateResponse");
    private final static QName _SendNotes_QNAME = new QName("http://ws.bocsh.com/", "sendNotes");
    private final static QName _GetTellerResponse_QNAME = new QName("http://ws.bocsh.com/", "getTellerResponse");
    private final static QName _SendMail_QNAME = new QName("http://ws.bocsh.com/", "sendMail");
    private final static QName _GetFuncionTreeResponse_QNAME = new QName("http://ws.bocsh.com/", "getFuncionTreeResponse");
    private final static QName _GetFuncionTree_QNAME = new QName("http://ws.bocsh.com/", "getFuncionTree");
    private final static QName _QuerySubBranchListResponse_QNAME = new QName("http://ws.bocsh.com/", "querySubBranchListResponse");
    private final static QName _SendSms_QNAME = new QName("http://ws.bocsh.com/", "sendSms");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.boc.sh.sfjh.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PivsCheck }
     * 
     */
    public PivsCheck createPivsCheck() {
        return new PivsCheck();
    }

    /**
     * Create an instance of {@link ValidateUserResponse }
     * 
     */
    public ValidateUserResponse createValidateUserResponse() {
        return new ValidateUserResponse();
    }

    /**
     * Create an instance of {@link SendNotes }
     * 
     */
    public SendNotes createSendNotes() {
        return new SendNotes();
    }

    /**
     * Create an instance of {@link IsWorkingDate }
     * 
     */
    public IsWorkingDate createIsWorkingDate() {
        return new IsWorkingDate();
    }

    /**
     * Create an instance of {@link GetTellerResponse }
     * 
     */
    public GetTellerResponse createGetTellerResponse() {
        return new GetTellerResponse();
    }

    /**
     * Create an instance of {@link GetBIIFuncionTree }
     * 
     */
    public GetBIIFuncionTree createGetBIIFuncionTree() {
        return new GetBIIFuncionTree();
    }

    /**
     * Create an instance of {@link SendMailResponse }
     * 
     */
    public SendMailResponse createSendMailResponse() {
        return new SendMailResponse();
    }

    /**
     * Create an instance of {@link GetBIIFuncionTreeResponse }
     * 
     */
    public GetBIIFuncionTreeResponse createGetBIIFuncionTreeResponse() {
        return new GetBIIFuncionTreeResponse();
    }

    /**
     * Create an instance of {@link GetTellerFuncListResponse }
     * 
     */
    public GetTellerFuncListResponse createGetTellerFuncListResponse() {
        return new GetTellerFuncListResponse();
    }

    /**
     * Create an instance of {@link ChangeTellerPassResponse }
     * 
     */
    public ChangeTellerPassResponse createChangeTellerPassResponse() {
        return new ChangeTellerPassResponse();
    }

    /**
     * Create an instance of {@link BaseDomain }
     * 
     */
    public BaseDomain createBaseDomain() {
        return new BaseDomain();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link GetFuncionTree }
     * 
     */
    public GetFuncionTree createGetFuncionTree() {
        return new GetFuncionTree();
    }

    /**
     * Create an instance of {@link SendSms }
     * 
     */
    public SendSms createSendSms() {
        return new SendSms();
    }

    /**
     * Create an instance of {@link GetPinyinResponse }
     * 
     */
    public GetPinyinResponse createGetPinyinResponse() {
        return new GetPinyinResponse();
    }

    /**
     * Create an instance of {@link BiiNode }
     * 
     */
    public BiiNode createBiiNode() {
        return new BiiNode();
    }

    /**
     * Create an instance of {@link GetSubBranchList }
     * 
     */
    public GetSubBranchList createGetSubBranchList() {
        return new GetSubBranchList();
    }

    /**
     * Create an instance of {@link QuerySubBranchList }
     * 
     */
    public QuerySubBranchList createQuerySubBranchList() {
        return new QuerySubBranchList();
    }

    /**
     * Create an instance of {@link Teller }
     * 
     */
    public Teller createTeller() {
        return new Teller();
    }

    /**
     * Create an instance of {@link TreeNode.Attributes }
     * 
     */
    public TreeNode.Attributes createTreeNodeAttributes() {
        return new TreeNode.Attributes();
    }

    /**
     * Create an instance of {@link SendSmsResponse }
     * 
     */
    public SendSmsResponse createSendSmsResponse() {
        return new SendSmsResponse();
    }

    /**
     * Create an instance of {@link GetTeller }
     * 
     */
    public GetTeller createGetTeller() {
        return new GetTeller();
    }

    /**
     * Create an instance of {@link SendNotesResponse }
     * 
     */
    public SendNotesResponse createSendNotesResponse() {
        return new SendNotesResponse();
    }

    /**
     * Create an instance of {@link IsWorkingDateResponse }
     * 
     */
    public IsWorkingDateResponse createIsWorkingDateResponse() {
        return new IsWorkingDateResponse();
    }

    /**
     * Create an instance of {@link HashMap }
     * 
     */
    public HashMap createHashMap() {
        return new HashMap();
    }

    /**
     * Create an instance of {@link ValidateUser }
     * 
     */
    public ValidateUser createValidateUser() {
        return new ValidateUser();
    }

    /**
     * Create an instance of {@link GetSubBranchListResponse }
     * 
     */
    public GetSubBranchListResponse createGetSubBranchListResponse() {
        return new GetSubBranchListResponse();
    }

    /**
     * Create an instance of {@link GetBranch }
     * 
     */
    public GetBranch createGetBranch() {
        return new GetBranch();
    }

    /**
     * Create an instance of {@link TreeNode.Attributes.Entry }
     * 
     */
    public TreeNode.Attributes.Entry createTreeNodeAttributesEntry() {
        return new TreeNode.Attributes.Entry();
    }

    /**
     * Create an instance of {@link PivsCheckResponse }
     * 
     */
    public PivsCheckResponse createPivsCheckResponse() {
        return new PivsCheckResponse();
    }

    /**
     * Create an instance of {@link TreeNode }
     * 
     */
    public TreeNode createTreeNode() {
        return new TreeNode();
    }

    /**
     * Create an instance of {@link SendMail }
     * 
     */
    public SendMail createSendMail() {
        return new SendMail();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetFuncionTreeResponse }
     * 
     */
    public GetFuncionTreeResponse createGetFuncionTreeResponse() {
        return new GetFuncionTreeResponse();
    }

    /**
     * Create an instance of {@link GetTellerFuncList }
     * 
     */
    public GetTellerFuncList createGetTellerFuncList() {
        return new GetTellerFuncList();
    }

    /**
     * Create an instance of {@link GetPinyin }
     * 
     */
    public GetPinyin createGetPinyin() {
        return new GetPinyin();
    }

    /**
     * Create an instance of {@link QuerySubBranchListResponse }
     * 
     */
    public QuerySubBranchListResponse createQuerySubBranchListResponse() {
        return new QuerySubBranchListResponse();
    }

    /**
     * Create an instance of {@link Branch }
     * 
     */
    public Branch createBranch() {
        return new Branch();
    }

    /**
     * Create an instance of {@link ChangeTellerPass }
     * 
     */
    public ChangeTellerPass createChangeTellerPass() {
        return new ChangeTellerPass();
    }

    /**
     * Create an instance of {@link GetBranchResponse }
     * 
     */
    public GetBranchResponse createGetBranchResponse() {
        return new GetBranchResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeTellerPass }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "changeTellerPass")
    public JAXBElement<ChangeTellerPass> createChangeTellerPass(ChangeTellerPass value) {
        return new JAXBElement<ChangeTellerPass>(_ChangeTellerPass_QNAME, ChangeTellerPass.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuerySubBranchList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "querySubBranchList")
    public JAXBElement<QuerySubBranchList> createQuerySubBranchList(QuerySubBranchList value) {
        return new JAXBElement<QuerySubBranchList>(_QuerySubBranchList_QNAME, QuerySubBranchList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPinyinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getPinyinResponse")
    public JAXBElement<GetPinyinResponse> createGetPinyinResponse(GetPinyinResponse value) {
        return new JAXBElement<GetPinyinResponse>(_GetPinyinResponse_QNAME, GetPinyinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsWorkingDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "isWorkingDate")
    public JAXBElement<IsWorkingDate> createIsWorkingDate(IsWorkingDate value) {
        return new JAXBElement<IsWorkingDate>(_IsWorkingDate_QNAME, IsWorkingDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeTellerPassResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "changeTellerPassResponse")
    public JAXBElement<ChangeTellerPassResponse> createChangeTellerPassResponse(ChangeTellerPassResponse value) {
        return new JAXBElement<ChangeTellerPassResponse>(_ChangeTellerPassResponse_QNAME, ChangeTellerPassResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PivsCheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "pivsCheckResponse")
    public JAXBElement<PivsCheckResponse> createPivsCheckResponse(PivsCheckResponse value) {
        return new JAXBElement<PivsCheckResponse>(_PivsCheckResponse_QNAME, PivsCheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBranchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getBranchResponse")
    public JAXBElement<GetBranchResponse> createGetBranchResponse(GetBranchResponse value) {
        return new JAXBElement<GetBranchResponse>(_GetBranchResponse_QNAME, GetBranchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBIIFuncionTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getBIIFuncionTree")
    public JAXBElement<GetBIIFuncionTree> createGetBIIFuncionTree(GetBIIFuncionTree value) {
        return new JAXBElement<GetBIIFuncionTree>(_GetBIIFuncionTree_QNAME, GetBIIFuncionTree.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "validateUserResponse")
    public JAXBElement<ValidateUserResponse> createValidateUserResponse(ValidateUserResponse value) {
        return new JAXBElement<ValidateUserResponse>(_ValidateUserResponse_QNAME, ValidateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendNotesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "sendNotesResponse")
    public JAXBElement<SendNotesResponse> createSendNotesResponse(SendNotesResponse value) {
        return new JAXBElement<SendNotesResponse>(_SendNotesResponse_QNAME, SendNotesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTellerFuncListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getTellerFuncListResponse")
    public JAXBElement<GetTellerFuncListResponse> createGetTellerFuncListResponse(GetTellerFuncListResponse value) {
        return new JAXBElement<GetTellerFuncListResponse>(_GetTellerFuncListResponse_QNAME, GetTellerFuncListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTeller }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getTeller")
    public JAXBElement<GetTeller> createGetTeller(GetTeller value) {
        return new JAXBElement<GetTeller>(_GetTeller_QNAME, GetTeller.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubBranchList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getSubBranchList")
    public JAXBElement<GetSubBranchList> createGetSubBranchList(GetSubBranchList value) {
        return new JAXBElement<GetSubBranchList>(_GetSubBranchList_QNAME, GetSubBranchList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSmsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "sendSmsResponse")
    public JAXBElement<SendSmsResponse> createSendSmsResponse(SendSmsResponse value) {
        return new JAXBElement<SendSmsResponse>(_SendSmsResponse_QNAME, SendSmsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTellerFuncList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getTellerFuncList")
    public JAXBElement<GetTellerFuncList> createGetTellerFuncList(GetTellerFuncList value) {
        return new JAXBElement<GetTellerFuncList>(_GetTellerFuncList_QNAME, GetTellerFuncList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPinyin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getPinyin")
    public JAXBElement<GetPinyin> createGetPinyin(GetPinyin value) {
        return new JAXBElement<GetPinyin>(_GetPinyin_QNAME, GetPinyin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubBranchListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getSubBranchListResponse")
    public JAXBElement<GetSubBranchListResponse> createGetSubBranchListResponse(GetSubBranchListResponse value) {
        return new JAXBElement<GetSubBranchListResponse>(_GetSubBranchListResponse_QNAME, GetSubBranchListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "validateUser")
    public JAXBElement<ValidateUser> createValidateUser(ValidateUser value) {
        return new JAXBElement<ValidateUser>(_ValidateUser_QNAME, ValidateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBIIFuncionTreeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getBIIFuncionTreeResponse")
    public JAXBElement<GetBIIFuncionTreeResponse> createGetBIIFuncionTreeResponse(GetBIIFuncionTreeResponse value) {
        return new JAXBElement<GetBIIFuncionTreeResponse>(_GetBIIFuncionTreeResponse_QNAME, GetBIIFuncionTreeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "sendMailResponse")
    public JAXBElement<SendMailResponse> createSendMailResponse(SendMailResponse value) {
        return new JAXBElement<SendMailResponse>(_SendMailResponse_QNAME, SendMailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PivsCheck }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "pivsCheck")
    public JAXBElement<PivsCheck> createPivsCheck(PivsCheck value) {
        return new JAXBElement<PivsCheck>(_PivsCheck_QNAME, PivsCheck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBranch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getBranch")
    public JAXBElement<GetBranch> createGetBranch(GetBranch value) {
        return new JAXBElement<GetBranch>(_GetBranch_QNAME, GetBranch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsWorkingDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "isWorkingDateResponse")
    public JAXBElement<IsWorkingDateResponse> createIsWorkingDateResponse(IsWorkingDateResponse value) {
        return new JAXBElement<IsWorkingDateResponse>(_IsWorkingDateResponse_QNAME, IsWorkingDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendNotes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "sendNotes")
    public JAXBElement<SendNotes> createSendNotes(SendNotes value) {
        return new JAXBElement<SendNotes>(_SendNotes_QNAME, SendNotes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTellerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getTellerResponse")
    public JAXBElement<GetTellerResponse> createGetTellerResponse(GetTellerResponse value) {
        return new JAXBElement<GetTellerResponse>(_GetTellerResponse_QNAME, GetTellerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "sendMail")
    public JAXBElement<SendMail> createSendMail(SendMail value) {
        return new JAXBElement<SendMail>(_SendMail_QNAME, SendMail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFuncionTreeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getFuncionTreeResponse")
    public JAXBElement<GetFuncionTreeResponse> createGetFuncionTreeResponse(GetFuncionTreeResponse value) {
        return new JAXBElement<GetFuncionTreeResponse>(_GetFuncionTreeResponse_QNAME, GetFuncionTreeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFuncionTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "getFuncionTree")
    public JAXBElement<GetFuncionTree> createGetFuncionTree(GetFuncionTree value) {
        return new JAXBElement<GetFuncionTree>(_GetFuncionTree_QNAME, GetFuncionTree.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuerySubBranchListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "querySubBranchListResponse")
    public JAXBElement<QuerySubBranchListResponse> createQuerySubBranchListResponse(QuerySubBranchListResponse value) {
        return new JAXBElement<QuerySubBranchListResponse>(_QuerySubBranchListResponse_QNAME, QuerySubBranchListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bocsh.com/", name = "sendSms")
    public JAXBElement<SendSms> createSendSms(SendSms value) {
        return new JAXBElement<SendSms>(_SendSms_QNAME, SendSms.class, null, value);
    }

}
