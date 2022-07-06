window.onload = function () {
    document.getElementById('showButton').onclick = function () {
        if(document.getElementById('form1').style.display == 'none') {
            document.getElementById('form1').style.display = 'block'
        } else {
            document.getElementById('form1').style.display = 'none'
        }
    };

};