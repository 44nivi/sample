


$(document).ready(function() {

	$("#clicker").click(function() {

		var info = {
			name: $("#name").val(),
			mobile: $("#mob").val(),
			upload: $("#myfile").val()

		};


		alert(info.name);
		alert(info.mobile);
		$.ajax({
			type: "POST",
			datatype: 'json',
			data: JSON.stringify(info),
			contentType: 'application/json; charset=utf-8',
			url: "/register",
			success: function(N) {
				alert("Data successfully inserted");
			}

		});
	});
});

function demo(){
	var entries=JSON.parse(localStorage.getItem("1"))
	//var  = Object.entries(obj);
	console.log(entries);
	console.log(typeof entries);
	entries.forEach(user => {
                let tbl = document.createElement("table");
                let tbody = document.createElement("tbody");
                    let row = document.createElement("tr");
                    for (let key in user) {
                        if (key != 'filePath') {
                            let cell = document.createElement("td");
                            let text=document.createTextNode(user[key]);
                            cell.appendChild(text);
                            row.appendChild(cell);
                        }
            
                    //    else {
                    //        let cell = document.createElement("td");
                    //        let element = document.createElement('a');
                    //        let text=document.createTextNode("Download CV");
                    //        element.appendChild(text);
                    //        element.setAttribute('href',user[key]);
                    //        element.setAttribute("download",user["name"]);
                    //        //cell.appendChild('<a href='+user[key]+' download> Download CV</a>');
                    //        cell.appendChild(element);
                    //        row.appendChild(cell);
                    //    }
                    
                    }
                    tbody.appendChild(row);
                    tbl.appendChild(tbody);
                    tbl.setAttribute("border", "2");
                    document.body.appendChild(tbl);

                  
                });
}

function registration() {
	console.log("welcome");
	alert("call!!!");
	var infos = {
		name: $("#name").val()

	};

	console.log(infos);

	$.ajax({
		type: "POST",
		datatype: 'json',
		data: JSON.stringify(infos),
		contentType: 'application/json; charset=utf-8',
		url: "/jute",
		success: function namm(data = []) {
			//localStorage.setItem("data",data);
			alert("Data successfully retrieved");
			console.log(data);
			alert("hii");
			localStorage.setItem("1",JSON.stringify(data));
				
			//	data.forEach(user => {
            //    let tbl = document.createElement("table");
            //    let tbody = document.createElement("tbody");
            //        let row = document.createElement("tr");
            //        for (let key in user) {
            //            if (key != 'filePath') {
            //                let cell = document.createElement("td");
            //                let text=document.createTextNode(user[key]);
            //                cell.appendChild(text);
            //                row.appendChild(cell);
            //            }
            
                    //    else {
                    //        let cell = document.createElement("td");
                    //        let element = document.createElement('a');
                    //        let text=document.createTextNode("Download CV");
                    //        element.appendChild(text);
                    //        element.setAttribute('href',user[key]);
                    //        element.setAttribute("download",user["name"]);
                    //        //cell.appendChild('<a href='+user[key]+' download> Download CV</a>');
                    //        cell.appendChild(element);
                    //        row.appendChild(cell);
                    //    }
                    
              //      }
              //      tbody.appendChild(row);
              //      tbl.appendChild(tbody);
              //      tbl.setAttribute("border", "2");
                  
              //    });

		
	
		window.location="result.html";
                   	
		}
		
	
});
}