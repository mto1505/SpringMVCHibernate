// function person(name,age,onIn)
// {
//     this.name=name;
//     this.age=age;
//     this.onIn=onIn;
// }

// var fun=function handle(ob)
// {
//     console.log(ob.name);
// }

// var p=new person("minh",19,null);
// console.log(p)
// p.onIn=fun;
// p.onIn(p)

function validForm(formSeletor, options) {


    var formElement = $(formSeletor)[0];
    console.log(formElement);

    var rulesSelector = {};
    var formRules = {
        // input.name=value;
    };
    var validatorRules = {
        required: function (value) {
            return value ? undefined : 'Vui lòng nhập trường này';
        },
        phone: function (value) {

            var regExpMail = /^[0-9]{9}$/;
            return regExpMail.test(value) ? undefined : 'Số điện thoại không hợp lệ';

        },
        number: function (value) {
            var regExpMail = /^[0-9]{5}$/;
            return regExpMail.test(value) ? undefined : 'Số lượng không hợp lệ';

        },
        min: function (min) {
            return function (value) {
                return value.length > min ? undefined : ` Phải có ít nhất ${min} kí tự`;
            }
        },
        max: function (max) {
            return function (value) {
                return value.length < max ? undefined : `Chỉ chứa tối đa ${max} kí tự`;
            }
        },
        word: function (data) {
            var regWord = /^[0-9a-zA-Z]+$/;
            return regWord.test(data) ? undefined : `Trường không đúng định dạng(chỉ chứa các kí tự số và chữ cái)`;
        },
        text: function (data) {
            var regWord = /^[a-zA-Z]+$/;
            return regWord.test(data) ? undefined : `Trường không đúng định dạng(chỉ chứa các kí tự chữ cái)`;
        },
        licensePlate: function (data) {
            var regWord = /^[0-9a-zA-Z]+$/;
            return regWord.test(data) ? undefined : `Trường không đúng định dạng(86C121565)`;
        }

    }
    if (formElement) {

        var inputs = $(formElement).find("[name][rules]");
        //console.log(inputs);


        //duyệt qua từng input
        var arrInput = Array.from(inputs);

        //Handle rule từng input
        for (let input of arrInput) {
            //Lấy ra rule
            var ruleElements = $(input).attr("rules").split('|');

            for (let index = 0; index < ruleElements.length; index++) {
                const ruleElement = ruleElements[index];
                //check nest rules
                let isRuleNest = false;
                var ruleNestName;
                var ruleNestValue
                if (ruleElement.includes(':')) {
                    ruleNestName = ruleElement.split(':')[0];
                    ruleNestValue = ruleElement.split(':')[1];
                    isRuleNest = true;
                }
                // valid rule 
                var valueElementRule = validatorRules[ruleElement];
                //check rule nest
                if (isRuleNest) {
                    valueElementRule = validatorRules[ruleNestName](ruleNestValue);
                }

                // console.log(valueElementRule) 

                if (!Array.isArray(formRules[input.name])) {
                    formRules[input.name] = [valueElementRule];
                }
                else {
                    formRules[input.name].push(valueElementRule);
                }
            }
            if (input.id == "date") {
                input.onchange = handleEvent;

            }
            else {
                input.oninput = handleEvent;
            }


        }
        console.log(formRules)

        // Handle từng radio input
        let radioGroupsName = options.radioGroups;
        if(radioGroupsName!=undefined){
        for (let index = 0; index < radioGroupsName.length; index++) {
            let radioName = radioGroupsName[index]

            let radioInputElements = $(`[name="${radioName}"]`);
            for (let index = 0; index < radioInputElements.length; index++) {
                const inputElemnt = radioInputElements[index];

                inputElemnt.onclick = checkRadioGroup;

            }
            // console.log(radioInputElements)
            //checkRadioGroup(radioName)
        }}

        function handleEvent(e) {
            var errorMessage;
            var ruleHanlers = formRules[e.target.name];

            ruleHanlers.some((function (rule) {

                errorMessage = rule(e.target.value);
                return errorMessage;
            })
            )

            var errorParrent = $(e.target).parent();
            var errorElement = errorParrent.children(".form-message");
            if (errorMessage) {
                // show span error
                $(errorElement).addClass("text-danger font-italic");
                $(errorElement).text(errorMessage);
            }
            else {
              //  console.log(errorMessage)
                $(errorElement).text("");
            }

            return (!errorMessage)
        }
        function checkRadioGroup(event) {
            var radioName = event.target.name;

            var inputRadio = $(`input[name="${radioName}"]`).first();
         

            // message error
            var errorElementParrent = $(inputRadio).parents(".form-group");
          //  console.log(errorElementParrent)

            var errorElement = errorElementParrent.children(".form-message");

            //console.log(errorElement)

            //check input radio checked  
            var inputRadioChecked = $(`input[name="${radioName}"]:checked`);
            //console.log(inputRadioChecked)

            errorElement = errorElementParrent.children(".form-message");
            if (inputRadioChecked.val() === undefined) {
                // show span error
                $(errorElement).addClass("text-danger font-italic");
                $(errorElement).text("Vui lòng chọn trường này");
                return false;
            }
            else {
                console.log("radio checked")
                console.log(inputRadioChecked.val())
                $(errorElement).text("");

            }
            return true;

        }

    }


    formElement.onsubmit = function (event) {

        //event.preventDefault();

        var isValidForm =true;


        //check radio button group    
          let radioGroupsName = options.radioGroups;
        if(radioGroupsName!=undefined){

        for (let index = 0; index < radioGroupsName.length; index++) {

            const radioName = radioGroupsName[index];

            let radioInputElements = $(`[name="${radioName}"]`);
            //duyệt qua từng radio
            for (let index = 0; index < radioInputElements.length; index++) {

                const inputElemnt = radioInputElements[index];
               // console.log(inputElemnt.value)
                event = { target: inputElemnt };
                if (inputElemnt.checked == 1) {
                    //console.log("checked")
                    isValidForm = checkRadioGroup(event);
                    break;
                }
                else {
                    checkRadioGroup(event)
                };
            }
        }

            
        }

        var inputElements = $(formElement).find("[name][rules]");
        // console.log(inputElements)
        var inputElementArray=Array.from(inputElements);
        
        for (const input of inputElementArray) {
            event = {
                target: input
            }
            console.log(isValidForm)
            if (isValidForm == true) {
                isValidForm = handleEvent(event);
            }
            else {
                handleEvent(event);
            }
        }


        if (isValidForm) {
            //call function
         //   console.log("form submit")
        //    console.log(options.onSubmit)
            if (typeof options.onSubmit == "function") {
               
                let data=getFormValue();
                console.log(data)
                options.onSubmit(data);
                return true;
            }
            else {
                // formElement.submit();
                return false;
            }
        }
        else {
            console.log("có lỗi")
            return false;

        }
    };

    function getFormValue() {
        var data = {
        };

        var inputs = $(formElement).find('.form-control');
        var inputArray=Array.from(inputs);
        for (const input of inputArray) {
            if (input.type == "radio" && input.checked == 1) {
                data[input.name] = input.value;
            }
            else {
                data[input.name] = input.value;
            }
        }
       return data;
    }
    //funtion checke radio Group

    //other func

    validEmail = function (data) {
        return {
            selector: data,
            test: function (data) {
                return data ? undefined : "EMAIL"
            }
        }
    }
    validForm.isRequired = function (selector) {

        return {
            selector: selector,
            test: function (data) {
                return data ? undefined : "Vui lòng nhập trường này"
            }
        }

    }

    validForm.isLisencePlate = function (selector) {

        return {
            selector: selector,
            test: function (data) {
                var bienSoRegex = /^[0-9]{2}[a-zA-Z]{1}[0-9]{4,7}$/;
                return bienSoRegex.test(data) ? undefined : "Không đúng định dạng";
            }

        }
    }
    validForm.minMax = function (selector, min, max) {
        return {
            selector: selector,
            test: function (data) {
                return data.trim().lenght >= min && data.trim().lenght < max ? undefined : `"Thông tin chỉ chứa ${min} - ${max} kí tự"`
            }
        }

    }
    validForm.isWord = function (selector) {

        return {
            selector: selector,
            test: function (data) {

            }
        }
    }
    validForm.isPhone = function (selector) {

        return {
            selector: selector,
            test: function (data) {

            }
        }
    }
    validForm.isDateFormat = function (selector) {

        return {
            selector: selector,
            test: function (data) {

            }
        }
    }
    validForm.isText = function (selector) {
        return {
            selector: selector,
            test: function (data) {

            }
        }

    }
}

