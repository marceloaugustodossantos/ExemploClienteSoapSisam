
package com.pos.tabulacaows;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pos.tabulacaows package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pos.tabulacaows
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VariaveisView }
     * 
     */
    public VariaveisView createVariaveisView() {
        return new VariaveisView();
    }

    /**
     * Create an instance of {@link GetDadosTabulados }
     * 
     */
    public GetDadosTabulados createGetDadosTabulados() {
        return new GetDadosTabulados();
    }

    /**
     * Create an instance of {@link GetDadosTabuladosResponse }
     * 
     */
    public GetDadosTabuladosResponse createGetDadosTabuladosResponse() {
        return new GetDadosTabuladosResponse();
    }

}
