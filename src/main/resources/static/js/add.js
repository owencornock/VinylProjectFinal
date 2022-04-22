`use strict`

import * as DOM from '../dom.js';

const writeItem = item => {
  const child = document.createElement(`li`);
  child.id = item._id;
  child.innerHTML = `${JSON.stringify(item)}`;
  DOM.listOutput.appendChild(child);
}
const post = () => {
  axios.post(`http://localhost:8080/create`, {
    artist: DOM.inputArtist.value,
    album: DOM.inputAlbum.value,
    size: DOM.inputSize.value
  })
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
DOM.buttonCreate.onclick = () => post();