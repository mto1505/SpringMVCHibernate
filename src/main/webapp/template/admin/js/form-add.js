 //Upload and preview Image
    // Get element img 
    var imageElements = $(".image-review").toArray();
    //Get element input files

    var imageElementInput = $("input[type='file']").toArray();
    imageElementInput.forEach((item, index) => {
        item.onchange = evt => {
            var reader = new FileReader();
            var file = evt.target.files[0];
            if (file) {
                var output = $(imageElements[index]).src;
                output = URL.createObjectURL(file);
                $(imageElements[index]).attr("style", "background-image:url("+output+")")
                console.log(output);
                /* reader.onload = function () {
                    $(imageElements[index]).attr("background-image", `url(${output})`)
                }
                reader.readAsDataURL($("input[type='file']").get(index).files[0]); */
                output.onload = function () {
                    URL.revokeObjectURL(output.src);
                }
            }
        }
    }
    );
  //Handle button show list
    function handleEventShow() {
        var target = $(event.currentTarget)

        $(event.currentTarget).siblings("div.drop-down").addClass("active");


    }
    // handle event in memory list
    $(".menu-list-item").on("click", function () {
        // console.log("event on li " +event.target.textContent)
        //Get current parrent element
        var parent=$(this).parent(); //ul
         var childrenList=parent.children(); //li
            //  console.log(childrenList)
        $(childrenList).removeClass("select");
        $(this).addClass("select");
        //set input value
            //console.log( $(parent).parents("div.btn-click").children("input"))
        $(parent).parents("div.btn-click").children("input").val($(this).data("value"));
        var inputVal = $("#memoryValue").val();
        $(this).parents("div.drop-down").removeClass("active");
        //hiden drop-down
        $(this).parents("div.drop-down").siblings("button").text(event.target.textContent);
    });	

		//Show detail	
		$('.show-details-btn').on(
				'click',
				function(e) {
					e.preventDefault();
					$(this).closest('tr').next().toggleClass('open');
					$(this).find(ace.vars['.icon']).toggleClass(
							'fa-angle-double-down').toggleClass(
							'fa-angle-double-up');

				});

		$('#simple-table').on('click', 'td input[type=checkbox]', function() {
			var $row = $(this).closest('tr');
			if ($row.is('.detail-row '))
				return;
			if (this.checked)
				$row.addClass(active_class);
			else
				$row.removeClass(active_class);
		});

		/********************************/
		//add tooltip for small view action buttons in dropdown menu
		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});

		//tooltip placement on right or left
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			//var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}

		//And for the first simple table, which doesn't have TableTools or dataTables
		//select/deselect all rows according to table header checkbox
		var active_class = 'active';
		$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on(
				'click',
				function() {
					var th_checked = this.checked;//checkbox inside "TH" table header

					$(this).closest('table').find('tbody > tr').each(
							function() {
								var row = this;
								if (th_checked)
									$(row).addClass(active_class).find(
											'input[type=checkbox]').eq(0).prop(
											'checked', true);
								else
									$(row).removeClass(active_class).find(
											'input[type=checkbox]').eq(0).prop(
											'checked', false);
							});
				});

		//select/deselect a row when the checkbox is checked/unchecked
		$('#simple-table').on('click', 'td input[type=checkbox]', function() {
			var $row = $(this).closest('tr');
			if ($row.is('.detail-row '))
				return;
			if (this.checked)
				$row.addClass(active_class);
			else
				$row.removeClass(active_class);
		});
	
		
		//#####Pagination
		
		/* var totalPages = $
		{
			totalPage
		};
		var currentPage = $
		{
			page
		};
		var limit = 4;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 4,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(10);
						$('#page').val(page);
						$('#sortName').val('title');
						$('#sortBy').val('desc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		}); */
		
		
		// Validate and CRUD
		  $("#btnAddOrUpdate").click(function(e){

              //e.preventDefault();
               // var data={};
               // var $formArrayDataInput=$('#formSunmit').serializeArray();
               // console.log($formArrayDataInput);
               // var jsonString=JSON.stringify($formArrayDataInput);
               // console.log(jsonString);
               // serialize();
              
       });

       function serialize(dataObject){
           // var elements=$('#formSunmit').children().toArray();
           // console.log(elements);
           

           var arrayObject=Object.entries(dataObject).map(([key,value])=>{
                       return {[key]:value};
               });

           console.log(arrayObject)
           
           var dataJson={};
           
           arrayObject.forEach(element => {
               const propertyName=Object.keys(element)[0];

               let val=Object.values(element)[0];
               console.log(propertyName)
               console.log(val)
                
               var fullName=propertyName;

               var fullNameParts=fullName.split('.');

               var prefix='';
               var stack=dataJson;
               var s={};
               
               for (let index = 0; index < fullNameParts.length-1; index++) {
                   prefix = fullNameParts[index];
                      // console.log(prefix);
                   if(!stack[prefix])
                   {
                        stack[prefix]={};   
                   }
                   stack=stack[prefix]; //THAY ĐỔI STACK, lấy ra prefix cuối
                 //  console.log("sssss",s)              
               }
      
               //     thêm dữ liệu cho prefix cuối 
   
               var prefix2 = fullNameParts[fullNameParts.length - 1];
                if (stack[prefix2]) {
                      var newVal = stack[prefix2] + ',' + val;
                      stack[prefix2] += newVal;
                } else {
                   stack[prefix2] = val;
                }
           });
           return dataJson;

       }


       function edit(data)
       {
           $.ajax({
               url:"/quan-tri/product"
           })
           
       }
		
       var sanPhamObject;
       validForm("#form-submit",{
           // radioGroups:[
           //     "loai.id"     
           // ],
           onSubmit:function(dataObject)
           {
             sanPhamObject= serialize(dataObject);
             console.log(sanPhamObject);
           }
       });
       