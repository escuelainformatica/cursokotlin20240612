package cl.eftec.app20240612

fun elvis(valor:String?,defecto:String=""):String {
    if(valor==null) {
        return defecto
    }
    return valor
}