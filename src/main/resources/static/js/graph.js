document.getElementById('draw_graph_button').addEventListener("click", () => {
  let ExpGraphValue = document.getElementById('expressionField_graph').value;
  let FromValue = document.getElementById('FromValue').value;
  let ToValue = document.getElementById('ToValue').value;
  // let StepValue = document.getElementById('StepValue').value;

  let StepValue = 0.01;
  let range = Math.sqrt(Math.pow(ToValue - FromValue, 2));
  if (range > 100) StepValue = range/1000;
  // alert(StepValue);

  drawGraph(ExpGraphValue, FromValue, ToValue, StepValue)
});

const modelGraph = document.getElementById('Graph');
const graphView = modelGraph.getContext('2d');
let graphic = new Chart(graphView);

function drawGraph(exp, from, to, step) {
  if(exp === "") return;
  graphView.clearRect(0, 0, modelGraph.width, modelGraph.height);
  graphic.destroy();

  getGraphData(exp, from, to, step).then((resp) => {
  let xValues = resp[0];
  let yValues = resp[1];

  graphic = new Chart("Graph", {
    type: "line",
    data: {
      labels: xValues,
      datasets: [{
        fill: false,
        pointRadius: 1,
        borderColor: "rgba(255,0,0,0.5)",
        data: yValues
      }]
    },    
    options: {
      legend: {display: false},
      title: {
        display: true,
        text: exp,
        fontSize: 16
      }
    }
  });

  });
}

function getGraphData(exp, from, to, step) {
    const promise = axios.get(`/computeGraphValues`, {
        params: {
            exp: exp,
            from: from,
            to: to,
            step: step
        }
    });
    return promise.then((resp) => {
        return resp.data;
    });
}
