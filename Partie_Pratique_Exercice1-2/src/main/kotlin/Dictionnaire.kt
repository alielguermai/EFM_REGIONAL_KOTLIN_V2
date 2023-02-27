import java.io.IOException

class Dictionnaire {
    var liste = ArrayList<Entree>()
    fun nombreEntrees() : Int{
        return liste.size
    }
    fun ajouter(e : Entree){
        if (liste.contains(e))
            throw IOException("L'entree appartient deja au dictionnariel")
        liste.add(e)
    }
    fun supprimer(e : Entree) : Boolean{
        try {
            liste.remove(e)
            return true
        }catch (e : Exception){
            return false
        }
    }
    fun supprimer(motAnglais : String) : Boolean{
        for (x in liste){
            if (x.ang==motAnglais) {
                liste.remove(x)
                return true
            }
        }
        return false
    }
    fun anFr(motAnglais : String) : ArrayList<String>{
        var resultat = ArrayList<String>()
        for (x in liste){
            if (x.ang==motAnglais)
                resultat.add(x.fr)
        }
        return resultat
    }
    fun motsAnglais() : ArrayList<String>{
        var resultat_sans_doublans = HashSet<String>()
        for (x in liste){
            resultat_sans_doublans.add(x.ang)
        }
        var resultat = ArrayList<String>()
        for (x in resultat_sans_doublans){
            resultat.add(x)
        }
        return resultat
    }
    fun dictionnaireAnFr() : Map<String, ArrayList<String>>{
        var resultat = HashMap<String, ArrayList<String>>()
        for (x in this.motsAnglais()){
            resultat.put(x,anFr(x))
        }
        return resultat
    }

    override fun toString(): String {
        return this.dictionnaireAnFr().toString()
    }
}