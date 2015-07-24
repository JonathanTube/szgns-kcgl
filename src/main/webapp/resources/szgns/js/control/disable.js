function disable(){
				var str1 = $('#csh_from\\:cshDataTable_data tr:eq(1) td:eq(4)').text();
				var str2 = $('#csh_from\\:cshDataTable_data tr:eq(2) td:eq(4)').text();
				var str3 = $('#csh_from\\:cshDataTable_data tr:eq(3) td:eq(4)').text();
				var str4 = $('#csh_from\\:cshDataTable_data tr:eq(4) td:eq(4)').text();
				var str5 = $('#csh_from\\:cshDataTable_data tr:eq(5) td:eq(4)').text();
				var val = "审计无问题";
				var buttonval = $('#csh_from\\:cshDataTable_data tr:eq(6) td:eq(2)').text();
				var text = "未启用" ;
				if(buttonval ==text){
					$('#cshlc_panel .img').attr("src","../../../resources/hyjd/images/icons/unlock_s.png");
					if(val!=str1){
						$('#csh_from\\:cshDataTable_data tr:gt(1) td').css("background-color", "#ccc");
						$('#csh_from\\:cshDataTable_data tr:gt(1) td button').attr('disabled',"true");
						$('#csh_from\\:cshDataTable_data tr:gt(1) td button').css("background", "#ccc");
						$('#cshlc_panel .img').attr("src","../../../resources/hyjd/images/icons/lock_s.png");
						$('#cshlc_panel .img:lt(2)').attr("src","../../../resources/hyjd/images/icons/unlock_s.png");
					}else if(val!=str2){
						$('#csh_from\\:cshDataTable_data tr:gt(2) td').css("background-color", "#ccc");
						$('#csh_from\\:cshDataTable_data tr:gt(2) td button').attr('disabled',"true");
						$('#csh_from\\:cshDataTable_data tr:gt(2) td button').css("background", "#ccc");
						$('#cshlc_panel .img').attr("src","../../../resources/hyjd/images/icons/lock_s.png");
						$('#cshlc_panel .img:lt(3)').attr("src","../../../resources/hyjd/images/icons/unlock_s.png");
					}
					
					/*else if(val!=str3){
						$('#csh_from\\:cshDataTable_data tr:gt(3) td').css("background-color", "#ccc");
						$('#csh_from\\:cshDataTable_data tr:gt(3) td button').attr('disabled',"true");
						$('#csh_from\\:cshDataTable_data tr:gt(3) td button').css("background", "#ccc");
						$('#cshlc_panel .img').attr("src","../../../resources/hyjd/images/icons/lock_s.png");
						$('#cshlc_panel .img:lt(4)').attr("src","../../../resources/hyjd/images/icons/unlock_s.png");
					}*/
					
					else if(val!=str4){
						$('#csh_from\\:cshDataTable_data tr:gt(4) td').css("background-color", "#ccc");
						$('#csh_from\\:cshDataTable_data tr:gt(4) td button').attr('disabled',"true");
						$('#csh_from\\:cshDataTable_data tr:gt(4) td button').css("background", "#ccc");
						$('#cshlc_panel .img').attr("src","../../../resources/hyjd/images/icons/lock_s.png");
						$('#cshlc_panel .img:lt(5)').attr("src","../../../resources/hyjd/images/icons/unlock_s.png");
					}else if(val!=str5){
						$('#csh_from\\:cshDataTable_data tr:gt(5) td').css("background-color", "#ccc");
						$('#csh_from\\:cshDataTable_data tr:gt(5) td button').attr('disabled',"true");
						$('#csh_from\\:cshDataTable_data tr:gt(5) td button').css("background", "#ccc");
						$('#cshlc_panel .img').attr("src","../../../resources/hyjd/images/icons/lock_s.png");
						$('#cshlc_panel .img:lt(6)').attr("src","../../../resources/hyjd/images/icons/unlock_s.png");
					}
				}else{
					$('#csh_from\\:cshDataTable_data tr:lt(6) td button').attr('disabled',"true");
					$('#csh_from\\:cshDataTable_data tr:lt(6) td button').css("background", "#ccc");
					$('#csh_from\\:cshDataTable_data tr:lt(6) td').css("background-color", "#ccc");
					$('#cshlc_panel .img').attr("src","../../../resources/hyjd/images/icons/lock_s.png");
					$('#cshlc_panel .img:eq(6)').attr("src","../../../resources/hyjd/images/icons/unlock_s.png");
				}
			}