
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
object logInfo extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[String],Long,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(text: List[String], runID: Long = -1):play.api.templates.Html = {
        _display_ {
def /*17.2*/header/*17.8*/(key:String, title:String):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*17.38*/("""
    <th class=""""),_display_(Seq[Any](/*18.17*/key/*18.20*/.replace(".","_"))),format.raw/*18.37*/(""" header "headerSortUp"">
        <a href= >"""),_display_(Seq[Any](/*19.20*/title)),format.raw/*19.25*/("""</a>
    </th>
""")))};def /*6.2*/log/*6.5*/(logInfo:String) = {{
    
def replace = logInfo.replaceAll(_, _)

var logInfoFixed=replace("INFO:","<br/><font color=\"green\">INFO:</font>") replace("ERROR:","<br/><font color=\"red\">ERROR:</font>")

    //Output
    logInfoFixed
    
}};def /*27.2*/promptBug/*27.11*/(bug: Bug, index: Int) = {{
	var id : String = "addBugNum_" + index
	var funcName = "submitBugNum" + index
    var jscript : String = """<script>
	function """+funcName+"""(){
		$('#"""+id+"""').submit(function (){
			var formdata = $(this).serialize();
			alert("formdata="+formdata);
				$.ajax({
					type: "POST",
					url: jsRoutes.controllers.Application.addBugNum().url,
					data: formdata,
					success: function(data){
						alert('Submitted');
					}
				});
			document.getElementById(""""+id+"""").style.visibility = "hidden";
			return false;
		});
	}
	</script>"""
	
	var form : String = """<form id=""""+id+"""" name=""""+id+"""" method="POST">
	<fieldset>
	<div class="clearfix ">
		<label for="bugNum">Bug Number for difference: <b>"""+bug.difference.name+"""</b></label>
		<div class="input">
			<input type="text" id="number" name="number" value="" required pattern="\d*">
			<span class="help-inline">Required (Numbers only)</span>
		</div>
			<input type="hidden" id="id" name="id" value=""""+bug.id+"""">
		</div>
	</fieldset>

		<div class="actions">
			<input type="submit" value="Save this Bug Number" class="btn primary" onclick="return """+funcName+"""()">
	</div>

</form>"""
    
	Html(jscript+" \n "+form)
}};def /*72.2*/promptDifference/*72.18*/(difference: Difference, index: Int, files: String) = {{
	var id : String = "addDiffDesc_" + index
	var funcName = "submitDiffDesc" + index
    var jscript : String = """<script>
	function """+funcName+"""(){
		$('#"""+id+"""').submit(function (){
			var formdata = $(this).serialize();
			$.ajax({
				type: "POST",
				url: jsRoutes.controllers.Application.addDiffDesc().url,
				data: formdata,
				success: function(data){
					alert('Submitted');
				}
			});
			document.getElementById(""""+id+"""").style.visibility = "hidden";
			return false;
		});
	}
	</script>"""
	
	var form : String = """<form id=""""+id+"""" name=""""+id+"""" method="POST">
	<fieldset>
	<div class="clearfix ">
		<label for="DiffDesc">Please describe the difference that occureed in these files: <b>"""+files+"""</b></label>
		<div class="input">
			<input type="text" id="name" name="name" value="" required pattern="(\w|\s|\.|-)+">
			<span class="help-inline">Required (only word characters)</span>
		</div>
			<input type="hidden" id="id" name="id" value=""""+difference.id+"""">
		</div>
	</fieldset>

		<div class="actions">
			<input type="submit" value="Save this Difference" class="btn primary" onclick="return """+funcName+"""()">
	</div>

</form>"""
    
	Html(jscript+" \n "+form)
}};
Seq[Any](format.raw/*1.40*/("""

"""),format.raw/*5.30*/("""
"""),format.raw/*15.2*/("""

"""),format.raw/*21.2*/("""


"""),format.raw/*26.39*/("""
"""),format.raw/*68.2*/("""
"""),format.raw/*71.37*/("""
"""),format.raw/*112.2*/("""

"""),_display_(Seq[Any](/*114.2*/homeSkeleton/*114.14*/ {_display_(Seq[Any](format.raw/*114.16*/("""
	<script type="text/javascript" src="/assets/javascripts/routes"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		function reset()"""),format.raw/*118.19*/("""{"""),format.raw/*118.20*/("""
			var elements = document.getElementsByClassName("bug");
			for(var i=0; i<elements.length; i++)"""),format.raw/*120.40*/("""{"""),format.raw/*120.41*/("""
				elements[i].value="";
			"""),format.raw/*122.4*/("""}"""),format.raw/*122.5*/("""
			var elements2 = document.getElementsByClassName("difference");
			for(var i=0; i<elements2.length; i++)"""),format.raw/*124.41*/("""{"""),format.raw/*124.42*/("""
				elements2[i].value="";
			"""),format.raw/*126.4*/("""}"""),format.raw/*126.5*/("""
			return false;
		"""),format.raw/*128.3*/("""}"""),format.raw/*128.4*/("""
		function saveChanges()"""),format.raw/*129.25*/("""{"""),format.raw/*129.26*/("""
			//Tabulate changes to make
			var changes ="CHANGES TO MAKE: \n";
			var elements = document.getElementsByClassName("bug");
			for(var i=0; i<elements.length; i++)"""),format.raw/*133.40*/("""{"""),format.raw/*133.41*/("""
				if(elements[i].value!="")"""),format.raw/*134.30*/("""{"""),format.raw/*134.31*/("""
					var id=elements[i].id.substring(3);
					if(! /^\d+$/.test(elements[i].value))"""),format.raw/*136.43*/("""{"""),format.raw/*136.44*/("""
						alert("Entry "+elements[i].value+" Must only compose of digits");
						continue;
					"""),format.raw/*139.6*/("""}"""),format.raw/*139.7*/("""
					changes+="BugNum -> "+elements[i].value+"\n";
				"""),format.raw/*141.5*/("""}"""),format.raw/*141.6*/("""
			"""),format.raw/*142.4*/("""}"""),format.raw/*142.5*/("""
			var elements2 = document.getElementsByClassName("difference");
			for(var i=0; i<elements2.length; i++)"""),format.raw/*144.41*/("""{"""),format.raw/*144.42*/("""
				if(elements2[i].value!="")"""),format.raw/*145.31*/("""{"""),format.raw/*145.32*/("""
					var id=elements2[i].id.substring(4);
					changeDiff("name="+elements2[i].value+"&id="+id);
					changes+="Difference -> "+elements2[i].value+"\n";
				"""),format.raw/*149.5*/("""}"""),format.raw/*149.6*/("""
			"""),format.raw/*150.4*/("""}"""),format.raw/*150.5*/("""
			//Confirm changes
			if(!confirm("Are you sure you want to make these changes? \n"+changes ))"""),format.raw/*152.76*/("""{"""),format.raw/*152.77*/("""
				return false;
			"""),format.raw/*154.4*/("""}"""),format.raw/*154.5*/("""
			//Make the changes
			for(var i=0; i<elements.length; i++)"""),format.raw/*156.40*/("""{"""),format.raw/*156.41*/("""
				if(elements[i].value!="")"""),format.raw/*157.30*/("""{"""),format.raw/*157.31*/("""
					var id=elements[i].id.substring(3);
					if(! /^\d+$/.test(elements[i].value))"""),format.raw/*159.43*/("""{"""),format.raw/*159.44*/("""
						continue;
					"""),format.raw/*161.6*/("""}"""),format.raw/*161.7*/("""
					changeBug("number="+elements[i].value+"&id="+id);
				"""),format.raw/*163.5*/("""}"""),format.raw/*163.6*/("""
			"""),format.raw/*164.4*/("""}"""),format.raw/*164.5*/("""
			var elements2 = document.getElementsByClassName("difference");
			for(var i=0; i<elements2.length; i++)"""),format.raw/*166.41*/("""{"""),format.raw/*166.42*/("""
				if(elements2[i].value!="")"""),format.raw/*167.31*/("""{"""),format.raw/*167.32*/("""
					var id=elements2[i].id.substring(4);
					changeDiff("name="+elements2[i].value+"&id="+id);
				"""),format.raw/*170.5*/("""}"""),format.raw/*170.6*/("""
			"""),format.raw/*171.4*/("""}"""),format.raw/*171.5*/("""
			alert("Success");
			return false;
		"""),format.raw/*174.3*/("""}"""),format.raw/*174.4*/("""
		function changeBug(formdata)"""),format.raw/*175.31*/("""{"""),format.raw/*175.32*/("""
			$.ajax("""),format.raw/*176.11*/("""{"""),format.raw/*176.12*/("""
				type: "POST",
				url: jsRoutes.controllers.Application.addBugNum().url,
				data: formdata,
				success: function(data)"""),format.raw/*180.28*/("""{"""),format.raw/*180.29*/("""
				"""),format.raw/*181.5*/("""}"""),format.raw/*181.6*/("""
			"""),format.raw/*182.4*/("""}"""),format.raw/*182.5*/(""");
		"""),format.raw/*183.3*/("""}"""),format.raw/*183.4*/("""
		function changeDiff(formdata)"""),format.raw/*184.32*/("""{"""),format.raw/*184.33*/("""
			$.ajax("""),format.raw/*185.11*/("""{"""),format.raw/*185.12*/("""
				type: "POST",
				url: jsRoutes.controllers.Application.addDiffDesc().url,
				data: formdata,
				success: function(data)"""),format.raw/*189.28*/("""{"""),format.raw/*189.29*/("""
				"""),format.raw/*190.5*/("""}"""),format.raw/*190.6*/("""
			"""),format.raw/*191.4*/("""}"""),format.raw/*191.5*/(""");
		"""),format.raw/*192.3*/("""}"""),format.raw/*192.4*/("""
	</script>
	
	"""),_display_(Seq[Any](/*195.3*/if(runID !=(-1 : Long))/*195.26*/{_display_(Seq[Any](format.raw/*195.27*/("""
		<H2><a href='"""),_display_(Seq[Any](/*196.17*/routes/*196.23*/.Application.getData(runID))),format.raw/*196.50*/("""'>View Run</a><br/></H2>
	""")))})),format.raw/*197.3*/("""
	
	<div class="addInfo">
		<table class="Bug zebra-striped">
       		<center><h2>Bugs from this run:</h2> </center>
            <thead>
                <tr>
                    """),_display_(Seq[Any](/*204.22*/header("number", "Bug Number"))),format.raw/*204.52*/("""
					"""),_display_(Seq[Any](/*205.7*/header("difference.name", "Difference Desc"))),format.raw/*205.51*/(""" 
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*210.18*/for(bug <- Bug.listBugs(runID)) yield /*210.49*/ {_display_(Seq[Any](format.raw/*210.51*/("""
                    <tr>
                        <td><input type="text" class="bug" id="bug"""),_display_(Seq[Any](/*212.68*/bug/*212.71*/.id)),format.raw/*212.74*/("""" placeholder=""""),_display_(Seq[Any](/*212.90*/bug/*212.93*/.number)),format.raw/*212.100*/(""""></td>
						<td>
							"""),_display_(Seq[Any](/*214.9*/for(difference <- Bug.getDifferences(bug)) yield /*214.51*/ {_display_(Seq[Any](format.raw/*214.53*/("""
								"""),_display_(Seq[Any](/*215.10*/if(difference.difftype.name == "Worse")/*215.49*/ {_display_(Seq[Any](format.raw/*215.51*/("""
									<input type="text" class="difference" id="diff"""),_display_(Seq[Any](/*216.57*/difference/*216.67*/.id)),format.raw/*216.70*/("""" style="color:#FF0000" placeholder=""""),_display_(Seq[Any](/*216.108*/difference/*216.118*/.name)),format.raw/*216.123*/("""">
								""")))}/*217.11*/else/*217.16*/{_display_(Seq[Any](format.raw/*217.17*/("""
									"""),_display_(Seq[Any](/*218.11*/if(difference.difftype.name == "Better")/*218.51*/ {_display_(Seq[Any](format.raw/*218.53*/("""
										<input type="text" class="difference" id="diff"""),_display_(Seq[Any](/*219.58*/difference/*219.68*/.id)),format.raw/*219.71*/("""" style="color:#00FF00" placeholder=""""),_display_(Seq[Any](/*219.109*/difference/*219.119*/.name)),format.raw/*219.124*/("""">
									""")))}/*220.12*/else/*220.17*/{_display_(Seq[Any](format.raw/*220.18*/("""
										<input type="text" class="difference" id="diff"""),_display_(Seq[Any](/*221.58*/difference/*221.68*/.id)),format.raw/*221.71*/("""" style="color:#000000" placeholder=""""),_display_(Seq[Any](/*221.109*/difference/*221.119*/.name)),format.raw/*221.124*/("""">
									""")))})),format.raw/*222.11*/("""
								""")))})),format.raw/*223.10*/("""
								
								</br>
							""")))})),format.raw/*226.9*/("""
                        </td>
                    </tr>
					
                """)))})),format.raw/*230.18*/("""

            </tbody>
        </table>
		<div class="actions">
			<input type="submit" value="Reset" class="btn primary" onclick="return reset()">
			<input type="submit" value="Save changes" class="btn primary" onclick="return saveChanges()">
		</div>
	
	<div class="Log">
		<H1>Log:</H1>
		"""),_display_(Seq[Any](/*241.4*/for(line <- text) yield /*241.21*/{_display_(Seq[Any](format.raw/*241.22*/("""
			<br/> """),_display_(Seq[Any](/*242.11*/Html(log(line)))),format.raw/*242.26*/("""
		""")))})),format.raw/*243.4*/("""
	</div>
""")))})),format.raw/*245.2*/("""
"""))}
    }
    
    def render(text:List[String],runID:Long): play.api.templates.Html = apply(text,runID)
    
    def f:((List[String],Long) => play.api.templates.Html) = (text,runID) => apply(text,runID)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 17 09:59:51 EST 2014
                    SOURCE: C:/Users/dhallahan/workspace/regressionsiteRnd2-1/eclipse-regressionsite/app/views/logInfo.scala.html
                    HASH: 0687a9da59f4f3186642bd1fc1d263db99595e0c
                    MATRIX: 736->1|835->391|849->397|943->427|997->445|1009->448|1048->465|1129->510|1156->515|1196->135|1206->138|1468->660|1486->669|2779->2063|2804->2079|4150->39|4181->132|4210->386|4241->533|4275->657|4304->1948|4334->2060|4364->3395|4405->3400|4427->3412|4468->3414|4719->3636|4749->3637|4878->3737|4908->3738|4968->3770|4997->3771|5135->3880|5165->3881|5226->3914|5255->3915|5305->3937|5334->3938|5389->3964|5419->3965|5619->4136|5649->4137|5709->4168|5739->4169|5854->4255|5884->4256|6009->4353|6038->4354|6124->4412|6153->4413|6186->4418|6215->4419|6353->4528|6383->4529|6444->4561|6474->4562|6664->4724|6693->4725|6726->4730|6755->4731|6883->4830|6913->4831|6965->4855|6994->4856|7087->4920|7117->4921|7177->4952|7207->4953|7322->5039|7352->5040|7404->5064|7433->5065|7523->5127|7552->5128|7585->5133|7614->5134|7752->5243|7782->5244|7843->5276|7873->5277|8006->5382|8035->5383|8068->5388|8097->5389|8169->5433|8198->5434|8259->5466|8289->5467|8330->5479|8360->5480|8518->5609|8548->5610|8582->5616|8611->5617|8644->5622|8673->5623|8707->5629|8736->5630|8798->5663|8828->5664|8869->5676|8899->5677|9059->5808|9089->5809|9123->5815|9152->5816|9185->5821|9214->5822|9248->5828|9277->5829|9332->5848|9365->5871|9405->5872|9460->5890|9476->5896|9526->5923|9586->5951|9810->6138|9863->6168|9907->6176|9974->6220|10099->6308|10147->6339|10188->6341|10320->6436|10333->6439|10359->6442|10412->6458|10425->6461|10456->6468|10521->6497|10580->6539|10621->6541|10669->6552|10718->6591|10759->6593|10854->6651|10874->6661|10900->6664|10976->6702|10997->6712|11026->6717|11059->6731|11073->6736|11113->6737|11162->6749|11212->6789|11253->6791|11349->6850|11369->6860|11395->6863|11471->6901|11492->6911|11521->6916|11555->6931|11569->6936|11609->6937|11705->6996|11725->7006|11751->7009|11827->7047|11848->7057|11877->7062|11924->7076|11968->7087|12035->7122|12152->7206|12493->7511|12527->7528|12567->7529|12616->7541|12654->7556|12691->7561|12735->7573
                    LINES: 26->1|28->17|28->17|30->17|31->18|31->18|31->18|32->19|32->19|34->6|34->6|43->27|43->27|84->72|84->72|125->1|127->5|128->15|130->21|133->26|134->68|135->71|136->112|138->114|138->114|138->114|142->118|142->118|144->120|144->120|146->122|146->122|148->124|148->124|150->126|150->126|152->128|152->128|153->129|153->129|157->133|157->133|158->134|158->134|160->136|160->136|163->139|163->139|165->141|165->141|166->142|166->142|168->144|168->144|169->145|169->145|173->149|173->149|174->150|174->150|176->152|176->152|178->154|178->154|180->156|180->156|181->157|181->157|183->159|183->159|185->161|185->161|187->163|187->163|188->164|188->164|190->166|190->166|191->167|191->167|194->170|194->170|195->171|195->171|198->174|198->174|199->175|199->175|200->176|200->176|204->180|204->180|205->181|205->181|206->182|206->182|207->183|207->183|208->184|208->184|209->185|209->185|213->189|213->189|214->190|214->190|215->191|215->191|216->192|216->192|219->195|219->195|219->195|220->196|220->196|220->196|221->197|228->204|228->204|229->205|229->205|234->210|234->210|234->210|236->212|236->212|236->212|236->212|236->212|236->212|238->214|238->214|238->214|239->215|239->215|239->215|240->216|240->216|240->216|240->216|240->216|240->216|241->217|241->217|241->217|242->218|242->218|242->218|243->219|243->219|243->219|243->219|243->219|243->219|244->220|244->220|244->220|245->221|245->221|245->221|245->221|245->221|245->221|246->222|247->223|250->226|254->230|265->241|265->241|265->241|266->242|266->242|267->243|269->245
                    -- GENERATED --
                */
            