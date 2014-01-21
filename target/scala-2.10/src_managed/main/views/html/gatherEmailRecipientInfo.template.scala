
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object gatherEmailRecipientInfo extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/homeSkeleton/*1.14*/	{_display_(Seq[Any](format.raw/*1.16*/("""
<!DOCTYPE html>
  <html>
  <style>
p
"""),format.raw/*6.1*/("""{"""),format.raw/*6.2*/("""

"""),format.raw/*8.1*/("""}"""),format.raw/*8.2*/("""
p.padding
"""),format.raw/*10.1*/("""{"""),format.raw/*10.2*/("""
padding-top:25px;
padding-bottom:25px;
padding-right:50px;
padding-left:50px;
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/("""
</style>
  <head>
      <meta charset="utf-8">
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*19.44*/routes/*19.50*/.Application.javascriptRoutes())),format.raw/*19.81*/(""""></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
      <link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*21.53*/routes/*21.59*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*21.102*/("""">
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*22.44*/routes/*22.50*/.Assets.at("js/jquery.chained.min.js"))),format.raw/*22.88*/("""" charset="utf-8"></script>
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*23.44*/routes/*23.50*/.Application.javascriptRoutes())),format.raw/*23.81*/(""""></script>
   </head>
   
   <body>
   	<center>
   	<h1>Add an Email Report</h1>
 	<br>
   	
   	  	<div class="clearfix ">
		<div class="input" margin:auto; floatwidth:70%; background-color:#b0e0e6;>

			"""),_display_(Seq[Any](/*34.5*/{var i = 0;				
			var str = "";
			val ffList : List[FileFormat] = FileFormat.getList();
			str = "<div Id='formatDiv'>"
			str = "<span>";
			while(i < ffList.length)	{
				str += "<input type=";
				str += "checkbox";
				str += " onchange=\'readFormats()\' ";
				str += " value = ";
				str += ffList(i).getFileFormatName();
				str += ">";
				str += "\t" + ffList(i).getFileFormatName() + "\t";
				str += "</input>";
					
				i+=1;
				if(i % 3 == 0)	{
					str += "</span>";
					str += "<br>";
					str += "<span>";
				}

				}
				if(i % 3 != 0)	{
					str += "</span>";					
			}
			str += "</div>";
			Html(str)
			})),format.raw/*62.5*/("""
				
			</div>
		</div>
		<button type='button' id='selectAllBtn' class="btn primary" onclick='selectAllFormats()'>select all</button>    

   	<!-- ignoring the checkboxes for now -->
   	<form action=""""),_display_(Seq[Any](/*69.20*/routes/*69.26*/.Application.addEmailRecipient())),format.raw/*69.58*/("""" method="post">
   		<input type="hidden" name="format" id="format">
   		<br>
   		<input name="address"> email address
   		<br><br>
   		<input type="submit" class="btn primary" value="Submit Request">
   	</form>
   	
   	</center>
   	
   	<script>
	function readFormats()	"""),format.raw/*80.25*/("""{"""),format.raw/*80.26*/("""
  		var formats = "";
  		$('input:checked').each(function()"""),format.raw/*82.39*/("""{"""),format.raw/*82.40*/("""formats += this.value + ", """"),format.raw/*82.68*/("""}"""),format.raw/*82.69*/(""");	
  		formats = formats.slice(0, -2);
  		
  		var msg = "sendEmail(): the following formats have been chosen:\n";
  		msg += formats + "\n";
  		msg += $('#emailAddress').val();
  		//alert(msg);
  		
  		var formatTextBox = document.getElementById("format");
  		formatTextBox.value = formats;
  		var debug;
  		
  	"""),format.raw/*94.4*/("""}"""),format.raw/*94.5*/("""
	function selectAllFormats()	"""),format.raw/*95.30*/("""{"""),format.raw/*95.31*/("""
		
		var buttonText = $('#selectAllBtn').html();
		
		if (buttonText === "select all")	"""),format.raw/*99.36*/("""{"""),format.raw/*99.37*/("""
			$('input:checkbox').prop('checked', false);
			$('input:checkbox').prop('checked', true);
			$('#selectAllBtn').html('deselect all');
		"""),format.raw/*103.3*/("""}"""),format.raw/*103.4*/("""
		else"""),format.raw/*104.7*/("""{"""),format.raw/*104.8*/("""
			$('input:checkbox').prop('checked', true);
			$('input:checkbox').prop('checked', false);
			$('#selectAllBtn').html('select all');
		"""),format.raw/*108.3*/("""}"""),format.raw/*108.4*/("""
					
		readFormats();

		var debug;
	"""),format.raw/*113.2*/("""}"""),format.raw/*113.3*/("""
  </script>
   </body>
   </html>
""")))})))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 17 09:59:50 EST 2014
                    SOURCE: C:/Users/dhallahan/workspace/regressionsiteRnd2-1/eclipse-regressionsite/app/views/gatherEmailRecipientInfo.scala.html
                    HASH: 9d2f14599a261e8b98a08923df761d6d49f4f53d
                    MATRIX: 815->1|835->13|874->15|943->58|970->59|1000->63|1027->64|1067->77|1095->78|1206->162|1234->163|1365->258|1380->264|1433->295|1631->457|1646->463|1712->506|1795->553|1810->559|1870->597|1978->669|1993->675|2046->706|2300->925|2980->1584|3228->1796|3243->1802|3297->1834|3615->2124|3644->2125|3735->2188|3764->2189|3820->2217|3849->2218|4209->2551|4237->2552|4296->2583|4325->2584|4445->2676|4474->2677|4646->2821|4675->2822|4711->2830|4740->2831|4910->2973|4939->2974|5011->3018|5040->3019
                    LINES: 29->1|29->1|29->1|34->6|34->6|36->8|36->8|38->10|38->10|43->15|43->15|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|62->34|90->62|97->69|97->69|97->69|108->80|108->80|110->82|110->82|110->82|110->82|122->94|122->94|123->95|123->95|127->99|127->99|131->103|131->103|132->104|132->104|136->108|136->108|141->113|141->113
                    -- GENERATED --
                */
            