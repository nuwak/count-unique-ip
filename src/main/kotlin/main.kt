fun main(args: Array<String>) {
    println(args.joinToString(","))
    val res = IpCounter(arrayOf("ips100.txt")).count()
    println(res)
}