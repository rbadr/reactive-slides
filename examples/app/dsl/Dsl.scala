package dsl

object Dsl {

  import scalatags.Text.all._
  import scalatags.Text.tags2.section
  import scalatags.Text.tags2.title

  def presentationTitle = "reveal.js - The HTML Presentation Framework"
  def presentation(titleText: String, theme: String, array: scalatags.Text.Modifier*) = // Ne pas renommer array en content, provoque un bug
    Seq(
      html(
        head(
          meta(charset := "utf-8"),

          title(titleText),

          meta(name := "description", content := "A framework for easily creating beautiful presentations using HTML"),
          meta(name := "author", content := "Author"),

          meta(name := "apple-mobile-web-app-capable", content := "yes"),
          meta(name := "apple-mobile-web-app-status-bar-style", content := "black-translucent"),

          meta(name := "viewport", content := "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"),

          link(rel := "stylesheet", href := "assets/stylesheets/reveal.css"),
          link(rel := "stylesheet", href := "assets/stylesheets/theme/"+theme+".css", id := "theme"),

          link(rel := "stylesheet", href := "assets/stylesheets/lib/zenburn.css")
        ), // Fermeture head

        body(
          div(`class` := "reveal",
            div(`class` := "slides", array)
          ),
          script(src := "assets/javascripts/lib/head.min.js")
        ), // Fermeture body
        script(src := "assets/javascripts/reveal.js")
      ), // Fermeture html
      script("Reveal.initialize({controls:true,progress:true,history:true,center:true,transition:'slide',dependencies:[{ src : 'assets/javascripts/lib/classList.js', condition: function() { return !document.body.classList; }},{ src : 'assets/plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad();}},{ src: 'assets/plugin/zoom-js/zoom.js',async:true},{ src : 'assets/plugin/notes/notes.js', async:true},{src:'assets/plugin/markdown/marked.js', condition : function(){ return !!document.querySelector('[data-markdown]'); }}, { src:'assets/plugin/markdown/markdown.js', condition: function(){ return !!document.querySelector('[data-markdown]');}}]});")
    ) // Fermeture Seq

  def slide(content: scalatags.Text.Modifier*) =
    section(content)

  def title1(content: scalatags.Text.Modifier*) =
    h1(content)

  def title2(content: scalatags.Text.Modifier*) =
    h2(content)

  def title3(content: scalatags.Text.Modifier*) =
    h3(content)

  def title4(content: scalatags.Text.Modifier*) =
    h4(content)

  def title5(content: scalatags.Text.Modifier*) =
    h5(content)

  def textLine(content: scalatags.Text.Modifier*) =
    p(content)

  def textLineFragment(content: scalatags.Text.Modifier*) =
    p(attr("class"):="fragment",content)

  def textFragment(content: scalatags.Text.Modifier*) =
    span(attr("class"):="fragment", content)

  def italic(content: String) =
    em(content)

  def bold(content: String) =
    strong(content)

  def emptyLine =
    br

  def unorderedList(content: scalatags.Text.Modifier*) =
    ul(content)

  def orderedList(content: scalatags.Text.Modifier*) =
    ol(content)

  def listItem(content: scalatags.Text.Modifier*) =
    li(content)

  def alink(content: scalatags.Text.Modifier*) =
    a(content)

  def tableRow(content: scalatags.Text.Modifier*) =
    tr(attr("class"):="reveal", content)

  def tableHead(content: scalatags.Text.Modifier*) =
    th(content)

  def tableBox(content: scalatags.Text.Modifier*) =
    td(content)

  def linkURL(content: String) =
    attr("href"):=content

  def sourceAttr(content: String) =
    attr("src"):=content

  def codeQuote(content: String) =
    pre(
      code(
        attr("data-trim"):="data-trim",
        attr("data-noescape"):="data-noescape",
        attr("class"):="hljs",
        content
      )
    )

}
