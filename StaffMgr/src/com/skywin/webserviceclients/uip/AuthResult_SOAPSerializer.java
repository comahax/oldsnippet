// Helper class generated by xrpcc, do not edit.
// Contents subject to change without notice.

package com.skywin.webserviceclients.uip;

import javax.xml.namespace.QName;

import com.sun.xml.rpc.encoding.CombinedSerializer;
import com.sun.xml.rpc.encoding.Initializable;
import com.sun.xml.rpc.encoding.InternalTypeMappingRegistry;
import com.sun.xml.rpc.encoding.ObjectSerializerBase;
import com.sun.xml.rpc.encoding.SOAPDeserializationContext;
import com.sun.xml.rpc.encoding.SOAPDeserializationState;
import com.sun.xml.rpc.encoding.SOAPSerializationContext;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.streaming.XMLReader;
import com.sun.xml.rpc.streaming.XMLReaderUtil;
import com.sun.xml.rpc.streaming.XMLWriter;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;

public class AuthResult_SOAPSerializer extends ObjectSerializerBase implements Initializable {
    private static final QName ns1_idsTokenValue_QNAME = new QName("", "idsTokenValue");
    private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
    private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
    private static final QName ns1_idsTokenName_QNAME = new QName("", "idsTokenName");
    private static final QName ns1_account_QNAME = new QName("", "account");
    private static final QName ns1_authResult_QNAME = new QName("", "authResult");
    private static final QName ns2_boolean_TYPE_QNAME = SchemaConstants.QNAME_TYPE_BOOLEAN;
    private CombinedSerializer myns2__boolean__boolean_Boolean_Serializer;
    private static final QName ns1_authMsg_QNAME = new QName("", "authMsg");
    private static final int myIDSTOKENVALUE_INDEX = 0;
    private static final int myIDSTOKENNAME_INDEX = 1;
    private static final int myACCOUNT_INDEX = 2;
    private static final int myAUTHRESULT_INDEX = 3;
    private static final int myAUTHMSG_INDEX = 4;
    
    public AuthResult_SOAPSerializer(QName type, boolean encodeType, boolean isNullable, String encodingStyle) {
        super(type, encodeType, isNullable, encodingStyle);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        myns2_string__java_lang_String_String_Serializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, java.lang.String.class, ns2_string_TYPE_QNAME);
        myns2__boolean__boolean_Boolean_Serializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, boolean.class, ns2_boolean_TYPE_QNAME);
    }
    
    public Object doDeserialize(SOAPDeserializationState state, XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        AuthResult instance = new AuthResult();
        AuthResult_SOAPBuilder builder = null;
        Object member;
        boolean isComplete = true;
        QName elementName;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_idsTokenValue_QNAME)) {
                member = myns2_string__java_lang_String_String_Serializer.deserialize(ns1_idsTokenValue_QNAME, reader, context);
                if (member instanceof SOAPDeserializationState) {
                    if (builder == null) {
                        builder = new AuthResult_SOAPBuilder();
                    }
                    state = registerWithMemberState(instance, state, member, myIDSTOKENVALUE_INDEX, builder);
                    isComplete = false;
                } else {
                    instance.setIdsTokenValue((java.lang.String)member);
                }
                reader.nextElementContent();
            }
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_idsTokenName_QNAME)) {
                member = myns2_string__java_lang_String_String_Serializer.deserialize(ns1_idsTokenName_QNAME, reader, context);
                if (member instanceof SOAPDeserializationState) {
                    if (builder == null) {
                        builder = new AuthResult_SOAPBuilder();
                    }
                    state = registerWithMemberState(instance, state, member, myIDSTOKENNAME_INDEX, builder);
                    isComplete = false;
                } else {
                    instance.setIdsTokenName((java.lang.String)member);
                }
                reader.nextElementContent();
            }
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_account_QNAME)) {
                member = myns2_string__java_lang_String_String_Serializer.deserialize(ns1_account_QNAME, reader, context);
                if (member instanceof SOAPDeserializationState) {
                    if (builder == null) {
                        builder = new AuthResult_SOAPBuilder();
                    }
                    state = registerWithMemberState(instance, state, member, myACCOUNT_INDEX, builder);
                    isComplete = false;
                } else {
                    instance.setAccount((java.lang.String)member);
                }
                reader.nextElementContent();
            }
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_authResult_QNAME)) {
                member = myns2__boolean__boolean_Boolean_Serializer.deserialize(ns1_authResult_QNAME, reader, context);
                instance.setAuthResult(((Boolean)member).booleanValue());
                reader.nextElementContent();
            }
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_authMsg_QNAME)) {
                member = myns2_string__java_lang_String_String_Serializer.deserialize(ns1_authMsg_QNAME, reader, context);
                if (member instanceof SOAPDeserializationState) {
                    if (builder == null) {
                        builder = new AuthResult_SOAPBuilder();
                    }
                    state = registerWithMemberState(instance, state, member, myAUTHMSG_INDEX, builder);
                    isComplete = false;
                } else {
                    instance.setAuthMsg((java.lang.String)member);
                }
                reader.nextElementContent();
            }
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (isComplete ? (Object)instance : (Object)state);
    }
    
    public void doSerializeInstance(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.skywin.webserviceclients.uip.AuthResult instance = (com.skywin.webserviceclients.uip.AuthResult)obj;
        
        myns2_string__java_lang_String_String_Serializer.serialize(instance.getIdsTokenValue(), ns1_idsTokenValue_QNAME, null, writer, context);
        myns2_string__java_lang_String_String_Serializer.serialize(instance.getIdsTokenName(), ns1_idsTokenName_QNAME, null, writer, context);
        myns2_string__java_lang_String_String_Serializer.serialize(instance.getAccount(), ns1_account_QNAME, null, writer, context);
        myns2__boolean__boolean_Boolean_Serializer.serialize(new Boolean(instance.isAuthResult()), ns1_authResult_QNAME, null, writer, context);
        myns2_string__java_lang_String_String_Serializer.serialize(instance.getAuthMsg(), ns1_authMsg_QNAME, null, writer, context);
    }
}
