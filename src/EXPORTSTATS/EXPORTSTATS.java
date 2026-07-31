package EXPORTSTATS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adeko.FM.FileManage;
import adeko.deko.JsonDeko;
import adeko.deko.Restore;
import adeko.types.ShortDate;
import adeko.types.Voidable;


public class EXPORTSTATS {
    static String exported = "EXPORTDATA";
    static String inport = "";
    public static Restore r;
    public static int precision = 3;

    public static void setJsonLocation(String s){
        inport = s;
    }

    public static void setSaveLocation(String s){
        exported = s;
    }

    public static List<String> getAllData(){
        List<String> elementInData = FileManage.listFileWithExtension(exported, ".bdeko");

        List<String> alt = new ArrayList<>(elementInData);
        for(String s : alt){
            System.out.println(!new Restore(exported+"/"+s).getB("EXPORTSTATS"));
            if(!new Restore(exported+"/"+s).getB("EXPORTSTATS")) elementInData.remove(s);
        }
        System.out.println(elementInData.size()+" exportstats located in ./"+exported);
        return elementInData;
    }

    public static List<String> getSimilarName(String s, Restore re){
        if(re.check(s)) return new ArrayList<>(Arrays.asList(s));
        return re.corresponds(s);
    }

    public static List<String> getSimilarName(String s){
        if(r.check(s)) return new ArrayList<>(Arrays.asList(s));
        return r.corresponds(s);
    }

    public static List<Stats> getTag(TagList tg){
        List<Stats> ls = new ArrayList<>();
        for(Stats e : Stats.values()) if(e.tag == tg) ls.add(e);
        return ls;
    }

    public static String getString(Stats st){
    Object o = r.get(st.toString());
    if (o == null) return ""; 

    if(o instanceof Boolean) return ((Boolean) o).toString();
    
    // 1. On stocke la valeur sous forme de BigDecimal pour garder 100% de la précision
    java.math.BigDecimal bd = null;
    if (o instanceof java.math.BigDecimal bdValue) bd = bdValue;
    else if (o instanceof Double dValue) bd = java.math.BigDecimal.valueOf(dValue);
    else if (o instanceof Integer iValue) bd = java.math.BigDecimal.valueOf(iValue);
    else if (o instanceof Long lValue) bd = java.math.BigDecimal.valueOf(lValue);

    // Si on n'a pas pu en faire un nombre, on prend la String brute
    String numberStr = (bd != null) ? bd.stripTrailingZeros().toPlainString() : o.toString();

    // Cas des Statues
    if (st.tag == TagList.Statues && bd != null) {
        try {
            int i = bd.intValueExact(); // Plus propre et sécurisé
            return switch(i){
                default -> "Not Owned";
                case 1 -> "Base";
                case 2 -> "Gilded";
                case 3 -> "Platinized";
            };
        } catch (ArithmeticException e) {
            return "Unknown Statue"; // Si le nombre ne rentre pas dans un int
        }
    }
    
    // Application de la précision si demandée
    if (bd != null && precision > -1) {
        numberStr = Notation.getBestNotation(bd);
    }
    
    // 2. Traitement des suffixes
    if (st.name().endsWith("chance") || st.name().endsWith("percent")) {
        return numberStr + "%"; 
    }
    
    if ((st.name().endsWith("multiplier") || st.name().endsWith("multi") || st.name().endsWith("crit_damage") || st.name().endsWith("rate")) && bd != null) {
        return numberStr + "x";
    }
    
    if ((st.name().endsWith("reduction") || st.name().endsWith("requirement")) && bd != null && bd.compareTo(java.math.BigDecimal.ZERO) > 0 && bd.compareTo(java.math.BigDecimal.ONE) < 0){
        java.math.BigDecimal red = java.math.BigDecimal.ONE.subtract(bd);
        if (precision > -1) {
            red = red.setScale(precision, java.math.RoundingMode.HALF_UP);
        }
        return red.stripTrailingZeros().toPlainString() + "x";
    }
    
    if (st.name().endsWith("seconds") || st.name().endsWith("second") && bd != null) {
        return numberStr + "s";
    }

    if (st.name().equals("time") && bd != null){
        return ShortDate.fromOADate(bd.doubleValue()).toString();
    }
    
    return numberStr;
}

    public static void convertJson(String json, int fileSave){
        long c = System.currentTimeMillis();
        String path = inport;
        String spath = path;
        if(Voidable.of(path) != null) spath+="/";

        String lastPath = spath + "last.bdeko";

        // On efface le VRAI fichier cible avant extraction, pour éviter
        // qu'extractString ne saute l'écriture (cas EXISTS) sur un résidu d'un run précédent
        FileManage.eraseFile(lastPath);

        try{
            JsonDeko.extractString(json, "last");
        } catch(Exception e){
            System.out.println(e);
            return;
        }

        Restore r = new Restore(lastPath);
        //if(!r.getB("EXPORTSTATS")) return;

        if(r.getB("EXPORTSTATS"))
            {
                ShortDate sd = ShortDate.fromOADate((double) r.get("time"));
                r.add("timestamp", sd.getTimestamp(), "auto");
            }
        FileManage.deplacerFichier(lastPath, exported+"/"+fileSave+".bdeko");

        System.out.println("total: "+(System.currentTimeMillis()-c));
    }

    public static void loadYoungestSave(int x){
        if(!saveExists(x)) return;
        r = new Restore(exported+"/"+x+".bdeko");
        System.out.println(r.check("precision"));
        if(r.check("precision")) precision = (int) r.get("precision");
    }

    public static void setPrecision(int setPrecision){
        if(r == null) {System.out.println("Erreur: Pas de Restore"); return;}
        r.replace("precision", setPrecision, "auto");
        precision = setPrecision;
    }

    public static boolean saveExists(int x){
        return new Restore(exported+"/"+x+".bdeko").exists();
    }
}
