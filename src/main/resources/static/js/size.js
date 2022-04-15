`use strict`

import * as DOM from '../dom.js';

const writeItem = item => {
    const child = document.createElement(`li`);
    child.id = item._id;
    child.innerHTML = `${JSON.stringify(item)}`;
    DOM.listOutput.appendChild(child);
}
const getSize = (size) => {
    DOM.sizeOutput.innerHTML = ``;
  
    axios.get(`http://localhost:8080/getBySize/${size}`)
      .then((response) => {
        if (!Array.isArray(response.data)) {
          writeItem(response.data);
        } else {
          for (let item of response.data) {
            writeItem(item);
          }
        }
      }).catch((err) => {
        console.log(err);
      });
  }
  DOM.buttonSize.onclick = () => getSize(DOM.inputFindSize.value);