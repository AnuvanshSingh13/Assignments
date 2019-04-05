fun main(){
    var hashSet=HashSet<Int>(6)
    hashSet.add(2)
    hashSet.add(7)
    hashSet.add(13)
    hashSet.add(6)
    hashSet.add(18)
    println("Element in HashSet: ")
    for (item in hashSet){
        println(item)
    }
}