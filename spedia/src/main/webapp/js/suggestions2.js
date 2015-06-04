
function StateSuggestions() {
    this.states = [
        "Alabama", "Alaska", "Arizona", "Arkansas",
        "California", "Colorado", "Connecticut",
        "Delaware", "Florida", "Georgia", "Hawaii",
        "Idaho", "Illinois", "Indiana", "Iowa",
        "Kansas", "Kentucky", "Louisiana",
        "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", 
        "Mississippi", "Missouri", "Montana",
        "Nebraska", "Nevada", "New Hampshire", "New Mexico", "New York",
        "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", 
        "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
        "Tennessee", "Texas", "Utah", "Vermont", "Virginia", 
        "Washington", "West Virginia", "Wisconsin", "Wyoming"  
    ];
	 
}

/**
 * Request suggestions for the given autosuggest control. 
 * @scope protected
 * @param oAutoSuggestControl The autosuggest control to provide suggestions for.
 */
StateSuggestions.prototype.requestSuggestions = function (oAutoSuggestControl /*:AutoSuggestControl*/,
                                                          bTypeAhead /*:boolean*/) {
    var sTextboxValue = oAutoSuggestControl.textbox.value;
    var e = document.getElementById("stateList");
    var state = e.options[e.selectedIndex].value;
    if (sTextboxValue.length > 0){
    	var aSuggestions = [];
   	 	var aurl="/spedia/autoSuggestSchools.json?term="+sTextboxValue+"&state="+state;
   	 	$.ajax({url: aurl, success: function(result){
   	 		//search for matching states
   	 	  var data = JSON.parse(JSON.stringify(result));
          for (var i=0; i < data.length; i++) { 
                  aSuggestions.push({key:data[i].id,value:data[i].title});
          }
        //provide suggestions to the control
          oAutoSuggestControl.autosuggest(aSuggestions, bTypeAhead);
        }});
    }
    
};