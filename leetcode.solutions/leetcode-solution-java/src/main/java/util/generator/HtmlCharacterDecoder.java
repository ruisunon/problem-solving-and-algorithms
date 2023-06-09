package util.generator;

public class HtmlCharacterDecoder extends Decoder {

    public HtmlCharacterDecoder() {
        addEscape("&#34;", '"');
        addEscape("&quot;", '"');
        addEscape("&apos;", '\'');
        addEscape("&#39;", '\'');
        addEscape("&#38;", '&');
        addEscape("&amp;", '&');
        addEscape("&#60;", '<');
        addEscape("&lt;", '<');
        addEscape("&#62;", '>');
        addEscape("&gt;", '>');
        addEscape("&#160;", ' ');
        addEscape("&nbsp;", ' ');
        addEscape("&#161;", '?');
        addEscape("&iexcl;", '?');
        addEscape("&#193;", 'Á');
        addEscape("&Aacute;", 'Á');
        addEscape("&#225;", 'á');
        addEscape("&aacute;", 'á');
        addEscape("&#162;", '￠');
        addEscape("&cent;", '￠');
        addEscape("&#194;", 'Â');
        addEscape("&circ;", 'Â');
        addEscape("&#226;", 'â');
        addEscape("&acirc;", 'â');
        addEscape("&#163;", '￡');
        addEscape("&pound;", '￡');
        addEscape("&#195;", 'Ã');
        addEscape("&Atilde;", 'Ã');
        addEscape("&#227;", 'ã');
        addEscape("&atilde;", 'ã');
        addEscape("&#164;", '¤');
        addEscape("&curren;", '¤');
        addEscape("&#196;", 'Ä');
        addEscape("&Auml;", 'Ä');
        addEscape("&#228;", 'ä');
        addEscape("&auml;", 'ä');
        addEscape("&#165;", '￥');
        addEscape("&yen;", '￥');
        addEscape("&#197;", 'Å');
        addEscape("&ring;", 'Å');
        addEscape("&#229;", 'å');
        addEscape("&aring;", 'å');
        addEscape("&#166;", '|');
        addEscape("&brvbar;", '|');
        addEscape("&#198;", 'Æ');
        addEscape("&AElig;", 'Æ');
        addEscape("&#230;", 'æ');
        addEscape("&aelig;", 'æ');
        addEscape("&#167;", '§');
        addEscape("&sect;", '§');
        addEscape("&#199;", 'Ç');
        addEscape("&Ccedil;", 'Ç');
        addEscape("&#231;", 'ç');
        addEscape("&ccedil;", 'ç');
        addEscape("&#168;", '¨');
        addEscape("&uml;", '¨');
        addEscape("&#200;", 'È');
        addEscape("&Egrave;", 'È');
        addEscape("&#232;", 'è');
        addEscape("&egrave;", 'è');
        addEscape("&#169;", '©');
        addEscape("&copy;", '©');
        addEscape("&#201;", 'É');
        addEscape("&Eacute;", 'É');
        addEscape("&#233;", 'é');
        addEscape("&eacute;", 'é');
        addEscape("&#170;", 'a');
        addEscape("&ordf;", 'a');
        addEscape("&#202;", 'Ê');
        addEscape("&Ecirc;", 'Ê');
        addEscape("&#234;", 'ê');
        addEscape("&ecirc;", 'ê');
        addEscape("&#171;", '?');
        addEscape("&laquo;", '?');
        addEscape("&#203;", 'Ë');
        addEscape("&Euml;", 'Ë');
        addEscape("&#235;", 'ë');
        addEscape("&euml;", 'ë');
        addEscape("&#172;", '?');
        addEscape("&not;", '?');
        addEscape("&#204;", 'Ì');
        addEscape("&Igrave;", 'Ì');
        addEscape("&#236;", 'ì');
        addEscape("&igrave;", 'ì');
        addEscape("&#173;", ' ');
        addEscape("&shy;", ' ');
        addEscape("&#205;", 'Í');
        addEscape("&Iacute;", 'Í');
        addEscape("&#237;", 'í');
        addEscape("&iacute;", 'í');
        addEscape("&#174;", '®');
        addEscape("&reg;", '®');
        addEscape("&#206;", 'Î');
        addEscape("&Icirc;", 'Î');
        addEscape("&#238;", 'î');
        addEscape("&icirc;", 'î');
        addEscape("&#175;", 'ˉ');
        addEscape("&macr;", 'ˉ');
        addEscape("&#207;", 'Ï');
        addEscape("&Iuml;", 'Ï');
        addEscape("&#239;", 'ï');
        addEscape("&iuml;", 'ï');
        addEscape("&#176;", '°');
        addEscape("&deg;", '°');
        addEscape("&#208;", 'Ð');
        addEscape("&ETH;", 'Ð');
        addEscape("&#240;", 'ð');
        addEscape("&ieth;", 'ð');
        addEscape("&#177;", '±');
        addEscape("&plusmn;", '±');
        addEscape("&#209;", 'Ñ');
        addEscape("&Ntilde;", 'Ñ');
        addEscape("&#241;", 'ñ');
        addEscape("&ntilde;", 'ñ');
        addEscape("&#178;", '2');
        addEscape("&sup2;", '2');
        addEscape("&#210;", 'Ò');
        addEscape("&Ograve;", 'Ò');
        addEscape("&#242;", 'ò');
        addEscape("&ograve;", 'ò');
        addEscape("&#179;", '3');
        addEscape("&sup3;", '3');
        addEscape("&#211;", 'Ó');
        addEscape("&Oacute;", 'Ó');
        addEscape("&#243;", 'ó');
        addEscape("&oacute;", 'ó');
        addEscape("&#180;", '′');
        addEscape("&acute;", '′');
        addEscape("&#212;", 'Ô');
        addEscape("&Ocirc;", 'Ô');
        addEscape("&#244;", 'ô');
        addEscape("&ocirc;", 'ô');
        addEscape("&#181;", 'μ');
        addEscape("&micro;", 'μ');
        addEscape("&#213;", 'Õ');
        addEscape("&Otilde;", 'Õ');
        addEscape("&#245;", 'õ');
        addEscape("&otilde;", 'õ');
        addEscape("&#182;", '?');
        addEscape("&para;", '?');
        addEscape("&#214;", 'Ö');
        addEscape("&Ouml;", 'Ö');
        addEscape("&#246;", 'ö');
        addEscape("&ouml;", 'ö');
        addEscape("&#183;", '·');
        addEscape("&middot;", '·');
        addEscape("&#215;", '×');
        addEscape("&times;", '×');
        addEscape("&#247;", '÷');
        addEscape("&divide;", '÷');
        addEscape("&#184;", '?');
        addEscape("&cedil;", '?');
        addEscape("&#216;", 'Ø');
        addEscape("&Oslash;", 'Ø');
        addEscape("&#248;", 'ø');
        addEscape("&oslash;", 'ø');
        addEscape("&#185;", '1');
        addEscape("&sup1;", '1');
        addEscape("&#217;", 'Ù');
        addEscape("&Ugrave;", 'Ù');
        addEscape("&#249;", 'ù');
        addEscape("&ugrave;", 'ù');
        addEscape("&#186;", 'o');
        addEscape("&ordm;", 'o');
        addEscape("&#218;", 'Ú');
        addEscape("&Uacute;", 'Ú');
        addEscape("&#250;", 'ú');
        addEscape("&uacute;", 'ú');
        addEscape("&#187;", '?');
        addEscape("&raquo;", '?');
        addEscape("&#219;", 'Û');
        addEscape("&Ucirc;", 'Û');
        addEscape("&#251;", 'û');
        addEscape("&ucirc;", 'û');
        addEscape("&#188;", '?');
        addEscape("&frac14;", '?');
        addEscape("&#220;", 'Ü');
        addEscape("&Uuml;", 'Ü');
        addEscape("&#252;", 'ü');
        addEscape("&uuml;", 'ü');
        addEscape("&#189;", '?');
        addEscape("&frac12;", '?');
        addEscape("&#221;", 'Ý');
        addEscape("&Yacute;", 'Ý');
        addEscape("&#253;", 'ý');
        addEscape("&yacute;", 'ý');
        addEscape("&#190;", '?');
        addEscape("&frac34;", '?');
        addEscape("&#222;", 'Þ');
        addEscape("&THORN;", 'Þ');
        addEscape("&#254;", 'þ');
        addEscape("&thorn;", 'þ');
        addEscape("&#191;", '?');
        addEscape("&iquest;", '?');
        addEscape("&#223;", 'ß');
        addEscape("&szlig;", 'ß');
        addEscape("&#255;", 'ÿ');
        addEscape("&yuml;", 'ÿ');
        addEscape("&#192;", 'À');
        addEscape("&Agrave;", 'À');
        addEscape("&#224;", 'à');
        addEscape("&agrave;", 'à');
        addEscape("&empty;", '∅');
    }
}
