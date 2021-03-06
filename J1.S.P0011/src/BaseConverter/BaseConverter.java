/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseConverter;

import java.math.BigInteger;

/**
 *
 * @author MSI Gaming
 */
public class BaseConverter {

    public static final String DIGITS = "0123456789ABCDEF";
    public static final int MIN_BASE = 2;
    public static final int MAX_BASE = 16;

    private int orginalBase;
    private int convertBase;

    /**
     * get invalid base message
     *
     * @param invalidBase invalid base
     * @return message
     */
    //in loi
    private String _getInvalidBaseMessage(int invalidBase) {
        return String.format("Invalid base, base = %d not in [%d, %d]", invalidBase, MIN_BASE, MAX_BASE);
    }

    /**
     * check if base is valid (base must be in [MIN_BASE, MAX_BASE])
     *
     * @param base checked base
     * @return true if base is valid, otherwise false
     */
    //check dk
    private boolean _isValidBase(int base) {
        return ((base >= MIN_BASE) && (base <= MAX_BASE));
    }

    public BaseConverter(int orginalBase, int convertBase) throws Exception {
        if (!this._isValidBase(orginalBase)) {
            throw new Exception(this._getInvalidBaseMessage(orginalBase));
        }

        this.orginalBase = orginalBase;

        if (!this._isValidBase(convertBase)) {
            throw new Exception(this._getInvalidBaseMessage(convertBase));
        }

        this.convertBase = convertBase;
    }

    public int getOrginalBase() {
        return orginalBase;
    }

    public int getConvertBase() {
        return convertBase;
    }

    /**
     * check if number is valid for converting
     *
     * @param number checked number
     * @return true if number is valid, otherwise false
     */
    private boolean _isValidNumber(String number) {
        for (int i = 0; i < number.length(); ++i) {
            int digit = DIGITS.indexOf(number.charAt(i));
            if ((digit < 0) || (digit >= this.orginalBase)) {
                return false;
            }
        }
        return true;
    }

    /**
     * convert number from original base to 10
     *
     * @param number convert number
     * @return converted number
     */
    private BigInteger _convertTo10(String number) {
        BigInteger converted = new BigInteger("0");

        BigInteger pow = new BigInteger("1");
        
        BigInteger a = new BigInteger(String.valueOf(this.orginalBase));

        for (int i = number.length() - 1; i >= 0; --i) {
            //1101

            int digit = DIGITS.indexOf(number.charAt(i));

            if (digit > 0) {
                converted = converted.add(pow.multiply(new BigInteger(String.valueOf(digit))));
            }

            // 2^0*1 + 2^1*0 + 2^2*1 + 2^3*1
            //convert = convert + (pow * digit)
            pow = pow.multiply(a);
            //pow = pow * orginalBase
        }
        return converted;

    }

    private StringBuilder _convertFrom10(BigInteger number) {
        StringBuilder converted = new StringBuilder();

        if (number.compareTo(new BigInteger("0")) == 0) {
            converted.insert(0, "0");
        }

        while (number.compareTo(new BigInteger("0")) > 0) //number > 0
        {
            //13
            int mod = Integer.parseInt(number.mod(new BigInteger(String.valueOf(this.convertBase))).toString()); // number % convertBase
            char digit = DIGITS.charAt(mod);

            converted.insert(0, (digit + "")); //1101

            number = number.divide(new BigInteger(String.valueOf(this.convertBase))); // number = number / convertBase
        }
        return converted;
    }

    /**
     * convert number from original base to convert base
     *
     * @param number
     * @return converted number
     * @throws java.lang.Exception if number is invalid to convert
     */
    public StringBuilder convert(String number) throws Exception {

        number = number.toUpperCase();

        if (!this._isValidNumber(number)) {
            throw new Exception("Invalid number, original base = " + String.valueOf(this.orginalBase));
        }

//        if (this.orginalBase == this.convertBase) {
//            return number;
//        }
        BigInteger base10 = _convertTo10(number);
        StringBuilder converted = _convertFrom10(base10);

//        BigInteger base10 = (this.orginalBase == 10) ? new BigInteger(number) : this._convertTo10(number);
//        String converted = (this.convertBase == 10) ? base10.toString() : this._convertFrom10(base10);
        return converted;

    }
}
