//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.05 at 10:22:34 PM CEST 
//


package pl.parser.nbp.xml;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numer_tabeli" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="data_notowania" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="data_publikacji" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="pozycja" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nazwa_waluty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="przelicznik" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="kod_waluty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="kurs_kupna" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="kurs_sprzedazy" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="typ" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numerTabeli",
    "dataNotowania",
    "dataPublikacji",
    "pozycja"
})
@XmlRootElement(name = "tabela_kursow")
public class TabelaKursow {

    @XmlElement(name = "numer_tabeli", required = true)
    protected String numerTabeli;
    @XmlElement(name = "data_notowania", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataNotowania;
    @XmlElement(name = "data_publikacji", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataPublikacji;
    @XmlElement(required = true)
    protected List<TabelaKursow.Pozycja> pozycja;
    @XmlAttribute(name = "typ")
    protected String typ;

    /**
     * Gets the value of the numerTabeli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerTabeli() {
        return numerTabeli;
    }

    /**
     * Sets the value of the numerTabeli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerTabeli(String value) {
        this.numerTabeli = value;
    }

    /**
     * Gets the value of the dataNotowania property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataNotowania() {
        return dataNotowania;
    }

    /**
     * Sets the value of the dataNotowania property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataNotowania(XMLGregorianCalendar value) {
        this.dataNotowania = value;
    }

    /**
     * Gets the value of the dataPublikacji property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataPublikacji() {
        return dataPublikacji;
    }

    /**
     * Sets the value of the dataPublikacji property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataPublikacji(XMLGregorianCalendar value) {
        this.dataPublikacji = value;
    }

    /**
     * Gets the value of the pozycja property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pozycja property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPozycja().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TabelaKursow.Pozycja }
     * 
     * 
     */
    public List<TabelaKursow.Pozycja> getPozycja() {
        if (pozycja == null) {
            pozycja = new ArrayList<TabelaKursow.Pozycja>();
        }
        return this.pozycja;
    }

    /**
     * Gets the value of the typ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTyp() {
        return typ;
    }

    /**
     * Sets the value of the typ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTyp(String value) {
        this.typ = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nazwa_waluty" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="przelicznik" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="kod_waluty" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="kurs_kupna" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="kurs_sprzedazy" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nazwaWaluty",
        "przelicznik",
        "kodWaluty",
        "kursKupna",
        "kursSprzedazy"
    })
    public static class Pozycja {

        @XmlElement(name = "nazwa_waluty", required = true)
        protected String nazwaWaluty;
        protected int przelicznik;
        @XmlElement(name = "kod_waluty", required = true)
        protected String kodWaluty;
        @XmlElement(name = "kurs_kupna", required = true, type = String.class)
        @XmlJavaTypeAdapter(Adapter1 .class)
        @XmlSchemaType(name = "decimal")
        protected BigDecimal kursKupna;
        @XmlElement(name = "kurs_sprzedazy", required = true, type = String.class)
        @XmlJavaTypeAdapter(Adapter2 .class)
        @XmlSchemaType(name = "decimal")
        protected BigDecimal kursSprzedazy;

        /**
         * Gets the value of the nazwaWaluty property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNazwaWaluty() {
            return nazwaWaluty;
        }

        /**
         * Sets the value of the nazwaWaluty property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNazwaWaluty(String value) {
            this.nazwaWaluty = value;
        }

        /**
         * Gets the value of the przelicznik property.
         * 
         */
        public int getPrzelicznik() {
            return przelicznik;
        }

        /**
         * Sets the value of the przelicznik property.
         * 
         */
        public void setPrzelicznik(int value) {
            this.przelicznik = value;
        }

        /**
         * Gets the value of the kodWaluty property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKodWaluty() {
            return kodWaluty;
        }

        /**
         * Sets the value of the kodWaluty property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKodWaluty(String value) {
            this.kodWaluty = value;
        }

        /**
         * Gets the value of the kursKupna property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public BigDecimal getKursKupna() {
            return kursKupna;
        }

        /**
         * Sets the value of the kursKupna property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKursKupna(BigDecimal value) {
            this.kursKupna = value;
        }

        /**
         * Gets the value of the kursSprzedazy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public BigDecimal getKursSprzedazy() {
            return kursSprzedazy;
        }

        /**
         * Sets the value of the kursSprzedazy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKursSprzedazy(BigDecimal value) {
            this.kursSprzedazy = value;
        }

    }

}
