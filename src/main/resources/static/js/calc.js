//alert("js load = ok");
//document.addEventListener('click', function(e){ console.log(e.target); });

const btn_delete = document.getElementById('btn_delete');
const btn_reset = document.getElementById('btn_reset');
const expressionField = document.getElementById('expressionField');
const x_value = document.getElementById('x_input');
const calculator_screen = document.getElementById('calculator_screen');

function getButtonText(src_btn) {
  return src_btn.textContent;
}

document
  .querySelectorAll('.btn_num, .btn_operator, .btn_func, .btn_etc')
  .forEach((button) => {
    let btn_value = button;

    if (button === btn_reset)
      button.onclick = function () {
        expressionField.value = '';
        calculator_screen.value = '0';
      };
    else
      button.onclick = function () {
        const myInsertText = getButtonText(btn_value);
        expressionField.value += myInsertText.replace(/ /g, '');
      };
  });

$('#btn_delete').on('click', function () {
  var textVal = $('#expressionField').val();
  $('#expressionField').val(textVal.substring(0, textVal.length - 1));
});
