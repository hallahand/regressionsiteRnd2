
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
object overview extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {
def /*1.2*/link/*1.6*/(f1:String, f2:String, p1:String, p2:String ) = {{
    
    
    
    // Generate the link
    routes.Application.dataList(f1, f2, p1, p2)
    
}};
Seq[Any](format.raw/*8.2*/("""



"""),_display_(Seq[Any](/*12.2*/homeSkeleton/*12.14*/{_display_(Seq[Any](format.raw/*12.15*/("""
<!DOCTYPE html>
  <html>
  <style>
p
"""),format.raw/*17.1*/("""{"""),format.raw/*17.2*/("""

"""),format.raw/*19.1*/("""}"""),format.raw/*19.2*/("""
p.padding
"""),format.raw/*21.1*/("""{"""),format.raw/*21.2*/("""
padding-top:25px;
padding-bottom:25px;
padding-right:50px;
padding-left:50px;
"""),format.raw/*26.1*/("""}"""),format.raw/*26.2*/("""
</style>
  <head>
      <meta charset="utf-8">
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*30.44*/routes/*30.50*/.Application.javascriptRoutes())),format.raw/*30.81*/(""""></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
      <link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*32.53*/routes/*32.59*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*32.102*/("""">
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*33.44*/routes/*33.50*/.Assets.at("js/jquery.chained.min.js"))),format.raw/*33.88*/("""" charset="utf-8"></script>
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*34.44*/routes/*34.50*/.Application.javascriptRoutes())),format.raw/*34.81*/(""""></script>
   </head>
   
   
   <center>
   <h1>Regression Testing Overview</h1>
   <p class="padding"></p>
   <body>
      
      
      <!-- The following code is dropdown menus. However, it uses
      the jquery library "chained select", so it might be a bit difficult to understand.
      Here is the basic idea. The first list gets all the platforms (calls a java function)
      and gives them a class based on their name. The second list gets all the formats and gives 
      them a class based on their name(i.e. Microsoft Word). 
      
      Now this sets up the last option. The last option will call every single run. However, it 
      will only display the run if the run shares the same format and platform. It does this by
      calling a function in Run, getPlatformFormat. This function just returns a string of
      the run's platform and format. Jquery checks to see that all the (option) classes are 
      the same.
      
      If you didn't get that, pretty much: class of the first drop down + class of the second drop down
	  must equal the class of third drop down. That is how jquery chained select works. 
	  
	  There are minor variations, but that's the basic idea.
      
      
      -->
      
      
      
      <select id="platform" name="#platform" onchange= "change('platform','format', 'pf')">
           <option value="Please select Platform">Please select Platform</option>
			"""),_display_(Seq[Any](/*68.5*/for(plat <- Platform.getList) yield /*68.34*/ {_display_(Seq[Any](format.raw/*68.36*/("""
           <option value="""),_display_(Seq[Any](/*69.27*/plat/*69.31*/.getPlatformName)),format.raw/*69.47*/(""" class = """),_display_(Seq[Any](/*69.57*/plat/*69.61*/.getPlatformName)),format.raw/*69.77*/("""> """),_display_(Seq[Any](/*69.80*/plat/*69.84*/.getPlatformName)),format.raw/*69.100*/("""</option>
           """)))})),format.raw/*70.13*/("""
      </select>
      <select id="format" name="#format" onchange= "change('platform','format', 'pf')"> 
           <option value="Please select Format">Please select Format</option>
           """),_display_(Seq[Any](/*74.13*/for(form <- FileFormat.getList) yield /*74.44*/ {_display_(Seq[Any](format.raw/*74.46*/("""
           <option value="""),_display_(Seq[Any](/*75.27*/form/*75.31*/.getFileFormatName)),format.raw/*75.49*/("""  class ="""),_display_(Seq[Any](/*75.59*/form/*75.63*/.getFileFormatName)),format.raw/*75.81*/(""">"""),_display_(Seq[Any](/*75.83*/form/*75.87*/.getFileFormatName)),format.raw/*75.105*/("""</option>
           """)))})),format.raw/*76.13*/("""
      </select>
      <select id="run" name="#run">
             
           """),_display_(Seq[Any](/*80.13*/for(run <- Run.getList) yield /*80.36*/ {_display_(Seq[Any](format.raw/*80.38*/("""
           <option value="""),_display_(Seq[Any](/*81.27*/run/*81.30*/.getRunID)),format.raw/*81.39*/("""   class = """),_display_(Seq[Any](/*81.51*/run/*81.54*/.getPlatformFormat)),format.raw/*81.72*/(""">"""),_display_(Seq[Any](/*81.74*/run/*81.77*/.getRunName)),format.raw/*81.88*/("""</option>
           """)))})),format.raw/*82.13*/("""
           <option value="" name= "AllRuns">All Runs</option>
           <option value="" name = "last5">Last 5 Runs</option>
           <option value="" name = "last10">Last 10 Runs</option>
           
      </select>
    <input type = "button" id = "pf" value= "Search" class="btn primary" disabled
    	onclick = "NavigateToSite('platform','format','version.platform.name', 'format.name','run')"/>
	<input type = "button" id = "sendEmailReport_pf" value= "Send Email Report" class="btn primary"
		onclick = "sendEmailReport_pf('platform','format','version.platform.name', 'format.name','run')"/>
       
      <p>
      
      OR
      </p>
       
       		<select id="platform2" name="#platform2" onchange= "buttonSel('platform2', 'pv')"> 
           		<option value="Please select Platform">Please select Platform</option>
					"""),_display_(Seq[Any](/*100.7*/for(plat <- Platform.getList) yield /*100.36*/ {_display_(Seq[Any](format.raw/*100.38*/("""
           		<option value="""),_display_(Seq[Any](/*101.29*/plat/*101.33*/.getPlatformName)),format.raw/*101.49*/(""" class = """),_display_(Seq[Any](/*101.59*/plat/*101.63*/.getPlatformName)),format.raw/*101.79*/("""> """),_display_(Seq[Any](/*101.82*/plat/*101.86*/.getPlatformName)),format.raw/*101.102*/("""</option>
           			""")))})),format.raw/*102.16*/("""
      		</select>
      		
      		<select id="version2" name="#version2" onchange= "buttonSel('version2', 'pv')">
           		<option value="">Please select Version</option>
           		"""),_display_(Seq[Any](/*107.15*/for(vers <- Version.getList) yield /*107.43*/ {_display_(Seq[Any](format.raw/*107.45*/("""
           		<option value="""),_display_(Seq[Any](/*108.29*/vers/*108.33*/.getVersionName)),format.raw/*108.48*/("""  class = """),_display_(Seq[Any](/*108.59*/vers/*108.63*/.getThePlatform.getPlatformName)),format.raw/*108.94*/(""">"""),_display_(Seq[Any](/*108.96*/vers/*108.100*/.getVersionName)),format.raw/*108.115*/("""</option>
           			""")))})),format.raw/*109.16*/("""
      		</select>
      		
      		
     	 	<select id="run2" name="#run2" >           
          		 """),_display_(Seq[Any](/*114.15*/for(run <- Run.getList) yield /*114.38*/ {_display_(Seq[Any](format.raw/*114.40*/("""
           		<option value="""),_display_(Seq[Any](/*115.29*/run/*115.32*/.getRunID)),format.raw/*115.41*/("""   class = """),_display_(Seq[Any](/*115.53*/run/*115.56*/.version.getVersionName)),format.raw/*115.79*/(""">"""),_display_(Seq[Any](/*115.81*/run/*115.84*/.getRunName)),format.raw/*115.95*/("""</option> 
           		""")))})),format.raw/*116.15*/("""
           		<option value="" name= "AllRuns">All Runs</option>
           		<option value="" name = "last5">Last 5 Runs</option>
           		<option value="" name = "last10">Last 10 Runs</option>
      		</select>
      		
      		<input type = "button" id = "pv" value= "Search" class="btn primary" 
       			onclick = "NavigateToSite('platform2','version2','version.platform.name', 'version.name','run2')"/>
			<input type = "button" id = "sendEmailReport_pv" value= "Send Email Report" class="btn primary"
				onclick = "sendEmailReport_pv()"/>
      
     <p>
     OR
     </p>  
  
  			<select id="date" name="#date" onchange= "buttonSel('date', 'dSelect')">
          	 	<option value="Choose from Dates">Choose from dates</option>
           		"""),_display_(Seq[Any](/*133.15*/for(da <- models.Date.getListUsed) yield /*133.49*/ {_display_(Seq[Any](format.raw/*133.51*/("""
           		<option value="""),_display_(Seq[Any](/*134.29*/da/*134.31*/.getDateName)),format.raw/*134.43*/("""  class = """),_display_(Seq[Any](/*134.54*/da/*134.56*/.getDateName)),format.raw/*134.68*/(""">"""),_display_(Seq[Any](/*134.70*/da/*134.72*/.getDateName)),format.raw/*134.84*/("""</option>
           		""")))})),format.raw/*135.15*/("""
      		</select>
      		
      		
      		<select id="run3" name="#run3">
           		"""),_display_(Seq[Any](/*140.15*/for(run <- Run.getList) yield /*140.38*/ {_display_(Seq[Any](format.raw/*140.40*/("""
           		<option value="""),_display_(Seq[Any](/*141.29*/run/*141.32*/.getRunID)),format.raw/*141.41*/("""  class = """),_display_(Seq[Any](/*141.52*/run/*141.55*/.getDateName)),format.raw/*141.67*/(""">"""),_display_(Seq[Any](/*141.69*/run/*141.72*/.getRunName)),format.raw/*141.83*/("""</option>
           		""")))})),format.raw/*142.15*/("""
           		 
      		</select>
      		
      		
      		<input type = "button" id = "dSelect" value= "Search" class="btn primary" 
      		onclick = "dateRun('run3')"/>
 	<p>
    </p>
    <br>
       		<input type = "button" id = "addEmailRecipient" value= "Add Email Recipient" class="btn primary"
 			onclick = "addEmailRecipient()"/>

<script>
/**
 * Redirects to proper run data
 *  p1: param one (format.name, etc)
 *  p2: param two
 *	list1: The first list you're pulling a value from...platform or platform
 *	list2: The second list you're pulling a value from..format or version
 *	called 2 different ways...
 *	NavigateToSite('platform','format','version.platform.name', 'format.name','run')
 *	NavigateToSite('platform2','version2','version.platform.name', 'version.name','run2')
 */
function NavigateToSite(list1,list2,p1,p2,id) """),format.raw/*166.47*/("""{"""),format.raw/*166.48*/("""

	var value = document.getElementById(id).value;	// run.Run_ID
	var option = document.getElementById(id).options[document.getElementById(id).selectedIndex].text;	// run.Run_Name
	var f1 = document.getElementById(list1).value;	// platform or platform2 dropdown
	var f2 = document.getElementById(list2).value;	// format   or version2  dropdown
	
	if (value == "")"""),format.raw/*173.18*/("""{"""),format.raw/*173.19*/("""
		if (option == 'All Runs')"""),format.raw/*174.28*/("""{"""),format.raw/*174.29*/("""
		
		window.location = jsRoutes.controllers.Application.dataList(f1,f2,p1,p2).url ;
		"""),format.raw/*177.3*/("""}"""),format.raw/*177.4*/("""
		else if (option == 'Last 5 Runs')"""),format.raw/*178.36*/("""{"""),format.raw/*178.37*/("""
			
			window.location = jsRoutes.controllers.Application.recentRuns(f1,f2,p1,p2,5).url ;
		"""),format.raw/*181.3*/("""}"""),format.raw/*181.4*/("""
		else """),format.raw/*182.8*/("""{"""),format.raw/*182.9*/(""" // Last 10 runs
			window.location = jsRoutes.controllers.Application.recentRuns(f1,f2,p1,p2,10).url ;
		"""),format.raw/*184.3*/("""}"""),format.raw/*184.4*/("""
	"""),format.raw/*185.2*/("""}"""),format.raw/*185.3*/("""
	else """),format.raw/*186.7*/("""{"""),format.raw/*186.8*/("""	// single runS
		
		window.location = jsRoutes.controllers.Application.getData(value).url ;
		
	"""),format.raw/*190.2*/("""}"""),format.raw/*190.3*/("""
	
	
"""),format.raw/*193.1*/("""}"""),format.raw/*193.2*/("""
 function dateRun(id) """),format.raw/*194.23*/("""{"""),format.raw/*194.24*/("""
		var value = document.getElementById(id).value;
		window.location = jsRoutes.controllers.Application.getData(value).url ;
	"""),format.raw/*197.2*/("""}"""),format.raw/*197.3*/("""
 /**
 These methods ensure that a button is disabled unless the 
 approriate fields are filled out.
 **/
 function buttonSel(doc1, doc2) """),format.raw/*202.33*/("""{"""),format.raw/*202.34*/("""
 	if (document.getElementById(doc1).selectedIndex == 0)
 		document.getElementById(doc2).disabled = true;
 	else
 	document.getElementById(doc2).disabled = false;
 	"""),format.raw/*207.3*/("""}"""),format.raw/*207.4*/("""
 function change(doc1, doc2, doc3) """),format.raw/*208.36*/("""{"""),format.raw/*208.37*/("""
	 	if (document.getElementById(doc1).selectedIndex == 0 || document.getElementById(doc2).selectedIndex == 0)
	 		document.getElementById(doc3).disabled = true;
	 	else
	 	document.getElementById(doc3).disabled = false;
	 	"""),format.raw/*213.4*/("""}"""),format.raw/*213.5*/("""
 
 
</script>
  
 
      
 

      <script language="JavaScript" type="text/javascript">
    /**
    This is what "chains" the the lists together. See full documentation:
    	http://www.appelsiini.net/projects/chained
    **/
      $("#run").chained("#platform, #format"); 
      $("#version2").chained("#platform2");
      $("#run2").chained("#version2"); 
      $("#run3").chained("#date"); 
      
      $('form').submit(function()"""),format.raw/*232.34*/("""{"""),format.raw/*232.35*/("""
    	    if($('#platform').val() == "" || $('#format').val() == "")"""),format.raw/*233.68*/("""{"""),format.raw/*233.69*/("""
    	        return false;
    	    """),format.raw/*235.10*/("""}"""),format.raw/*235.11*/("""
    	    """),format.raw/*236.10*/("""}"""),format.raw/*236.11*/(""");
      
      
      </script>

	<script type="text/javascript">
	
		function addEmailRecipient()	"""),format.raw/*243.32*/("""{"""),format.raw/*243.33*/("""
//			alert("addEmailRecipient()");
			location.assign("email");
		"""),format.raw/*246.3*/("""}"""),format.raw/*246.4*/("""
		
		function sendEmailReport_pf(list1,list2,p1,p2,id)	"""),format.raw/*248.53*/("""{"""),format.raw/*248.54*/("""
			
			//alert ("sendEmailReport_pf()");
			
			
	var value = document.getElementById(id).value;	// run.Run_ID
	var option = document.getElementById(id).options[document.getElementById(id).selectedIndex].text;	// run.Run_Name
	var f1 = document.getElementById(list1).value;	// platform or platform2 dropdown
	var f2 = document.getElementById(list2).value;	// format   or version2  dropdown

	
			var platform = $('#platform').val();
			var format = $('#format').val();
			var platformSearchIndex = platform.search(/Please select Platform/);
			var formatSearchIndex = format.search(/Please select Format/);
			if (platform.search(/Please select Platform/) >= 0 ||
				format.search(/Please select Format/) >= 0)
				alert ("Please select Platform and Format");
			else
//				location.assign("sendemail");
				window.location = jsRoutes.controllers.Application.sendRecentRunsEmailReport(f1,f2,p1,p2,5).url ;

		"""),format.raw/*270.3*/("""}"""),format.raw/*270.4*/("""
		function sendEmailReport_pv()	"""),format.raw/*271.33*/("""{"""),format.raw/*271.34*/("""
			alert ("sendEmailReport_pv(): TODO");
			var platform = $('#platform2').val();
			var version = $('#version2').val();
			
//			location.assign("sendemail");
		"""),format.raw/*277.3*/("""}"""),format.raw/*277.4*/("""
	</script>

  </body>
 
"""),format.raw/*286.19*/("""
  <p>
  </p>

  """),_display_(Seq[Any](/*290.4*/runChart/*290.12*/ {_display_(Seq[Any](format.raw/*290.14*/("""
""")))})),format.raw/*291.2*/("""

</center>


       
           
      

""")))})))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Feb 12 14:10:19 EST 2014
                    SOURCE: C:/Users/dhallahan/workspace/regressionsiteRnd2-1/eclipse-regressionsite/app/views/overview.scala.html
                    HASH: 6201a961113182764ff1810bb0d722962df3b6e2
                    MATRIX: 774->1|785->5|966->157|1010->166|1031->178|1070->179|1140->222|1168->223|1199->227|1227->228|1267->241|1295->242|1406->326|1434->327|1565->422|1580->428|1633->459|1831->621|1846->627|1912->670|1995->717|2010->723|2070->761|2178->833|2193->839|2246->870|3738->2327|3783->2356|3823->2358|3887->2386|3900->2390|3938->2406|3984->2416|3997->2420|4035->2436|4074->2439|4087->2443|4126->2459|4181->2482|4417->2682|4464->2713|4504->2715|4568->2743|4581->2747|4621->2765|4667->2775|4680->2779|4720->2797|4758->2799|4771->2803|4812->2821|4867->2844|4986->2927|5025->2950|5065->2952|5129->2980|5141->2983|5172->2992|5220->3004|5232->3007|5272->3025|5310->3027|5322->3030|5355->3041|5410->3064|6301->3919|6347->3948|6388->3950|6455->3980|6469->3984|6508->4000|6555->4010|6569->4014|6608->4030|6648->4033|6662->4037|6702->4053|6761->4079|6994->4275|7039->4303|7080->4305|7147->4335|7161->4339|7199->4354|7247->4365|7261->4369|7315->4400|7354->4402|7369->4406|7408->4421|7467->4447|7612->4555|7652->4578|7693->4580|7760->4610|7773->4613|7805->4622|7854->4634|7867->4637|7913->4660|7952->4662|7965->4665|7999->4676|8058->4702|8869->5476|8920->5510|8961->5512|9028->5542|9040->5544|9075->5556|9123->5567|9135->5569|9170->5581|9209->5583|9221->5585|9256->5597|9314->5622|9447->5718|9487->5741|9528->5743|9595->5773|9608->5776|9640->5785|9688->5796|9701->5799|9736->5811|9775->5813|9788->5816|9822->5827|9880->5852|10777->6720|10807->6721|11205->7090|11235->7091|11293->7120|11323->7121|11441->7211|11470->7212|11536->7249|11566->7250|11690->7346|11719->7347|11756->7356|11785->7357|11921->7465|11950->7466|11981->7469|12010->7470|12046->7478|12075->7479|12204->7580|12233->7581|12269->7589|12298->7590|12351->7614|12381->7615|12537->7743|12566->7744|12738->7887|12768->7888|12967->8059|12996->8060|13062->8097|13092->8098|13348->8326|13377->8327|13861->8782|13891->8783|13989->8852|14019->8853|14087->8892|14117->8893|14157->8904|14187->8905|14323->9012|14353->9013|14451->9083|14480->9084|14567->9142|14597->9143|15558->10076|15587->10077|15650->10111|15680->10112|15877->10281|15906->10282|15965->10376|16023->10398|16041->10406|16082->10408|16117->10411
                    LINES: 28->1|28->1|36->8|40->12|40->12|40->12|45->17|45->17|47->19|47->19|49->21|49->21|54->26|54->26|58->30|58->30|58->30|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|96->68|96->68|96->68|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|98->70|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|104->76|108->80|108->80|108->80|109->81|109->81|109->81|109->81|109->81|109->81|109->81|109->81|109->81|110->82|128->100|128->100|128->100|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|130->102|135->107|135->107|135->107|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|137->109|142->114|142->114|142->114|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|144->116|161->133|161->133|161->133|162->134|162->134|162->134|162->134|162->134|162->134|162->134|162->134|162->134|163->135|168->140|168->140|168->140|169->141|169->141|169->141|169->141|169->141|169->141|169->141|169->141|169->141|170->142|194->166|194->166|201->173|201->173|202->174|202->174|205->177|205->177|206->178|206->178|209->181|209->181|210->182|210->182|212->184|212->184|213->185|213->185|214->186|214->186|218->190|218->190|221->193|221->193|222->194|222->194|225->197|225->197|230->202|230->202|235->207|235->207|236->208|236->208|241->213|241->213|260->232|260->232|261->233|261->233|263->235|263->235|264->236|264->236|271->243|271->243|274->246|274->246|276->248|276->248|298->270|298->270|299->271|299->271|305->277|305->277|310->286|314->290|314->290|314->290|315->291
                    -- GENERATED --
                */
            