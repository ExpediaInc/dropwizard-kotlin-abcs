package dropwizard.kotlin.service.core

class Template(private val content: String, private val defaultName: String) {

    fun render(name: String?): String {
        return content.format(name?: defaultName)
    }
}