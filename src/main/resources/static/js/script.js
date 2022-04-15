// `use strict`

// import * as DOM from '../dom.js';

// const writeItem = item => {
//     const child = document.createElement(`li`);
//     child.id = item._id;
//     child.innerHTML = `${JSON.stringify(item)}`;
//     DOM.listOutput.appendChild(child);
// }

// const get = () => {
//     DOM.listOutput.innerHTML = ``;
  
//     axios.get(`http://localhost:8080/getAll`)
//       .then((response) => {
//         if (!Array.isArray(response.data)) {
//           writeItem(response.data);
//         } else {
//           for (let item of response.data) {
//             writeItem(item);
//           }
//         }
//       }).catch((err) => {
//         console.log(err);
//       });
//   }

//   const post = () => {
//     axios.post(`http://localhost:8080/create`, {
//       artist: DOM.inputArtist.value,
//       album: DOM.inputAlbum.value,
//       size: DOM.inputSize.value
//     })
//       .then((response) => {
//         console.log(response);
//       }).catch((err) => {
//         console.log(err);
//       });
//   }

//   const getNew = (id) => {
//     DOM.listOutput.innerHTML = ``;
  
//     axios.get(`http://localhost:8080/get/${id}`)
//       .then((response) => {
//         if (!Array.isArray(response.data)) {
//           writeItem(response.data);
//         } else {
//           for (let item of response.data) {
//             writeItem(item);
//           }
//         }
//       }).catch((err) => {
//         console.log(err);
//       });
//   }
//   const put = (id) => {
//       axios.put(`http://localhost:8080/replace/${id}`, {
//           id: DOM.inputUpdateId.value,
//           artist: DOM.inputUpdateArtist.value,
//           album: DOM.inputUpdateAlbum.value,
//           size: DOM.inputUpdateSize.value
//       })
//       .then((response) => {
//           console.log(response);
//       }).catch((err) => {
//           console.log(err);
//       });
//   }
//   const deleteId = (id) => {
//       axios.delete(`http://localhost:8080/remove/${id}`, { id: DOM.inputDeleteId.value })
//       .then((response) => {
//           console.log(response);
//       }).catch((err) => {
//           console.log(err);
//       });
//   }
//   const getArtist = (artist) => {
//     DOM.artistOutput.innerHTML = ``;
  
//     axios.get(`http://localhost:8080/getByArtist/${artist}`)
//       .then((response) => {
//         if (!Array.isArray(response.data)) {
//           writeItem(response.data);
//         } else {
//           for (let item of response.data) {
//             writeItem(item);
//           }
//         }
//       }).catch((err) => {
//         console.log(err);
//       });
//   }
//   const getAlbum = (album) => {
//     DOM.albumOutput.innerHTML = ``;
  
//     axios.get(`http://localhost:8080/getByAlbum/${album}`)
//       .then((response) => {
//         if (!Array.isArray(response.data)) {
//           writeItem(response.data);
//         } else {
//           for (let item of response.data) {
//             writeItem(item);
//           }
//         }
//       }).catch((err) => {
//         console.log(err);
//       });
//   }
//   const getSize = (size) => {
//     DOM.sizeOutput.innerHTML = ``;
  
//     axios.get(`http://localhost:8080/getBySize/${size}`)
//       .then((response) => {
//         if (!Array.isArray(response.data)) {
//           writeItem(response.data);
//         } else {
//           for (let item of response.data) {
//             writeItem(item);
//           }
//         }
//       }).catch((err) => {
//         console.log(err);
//       });
//   }

  
//   DOM.buttonReadAll.onclick = () => get();
//   DOM.buttonCreate.onclick = () => post();
//   DOM.buttonRead.onclick = () => getNew(DOM.inputId.value);
//   DOM.buttonUpdate.onclick = () => put(DOM.inputUpdateId.value);
//   DOM.buttonDelete.onclick = () => deleteId(DOM.inputDeleteId.value);
//   DOM.buttonArtist.onclick = () => getArtist(DOM.inputFindArtist.value);
//   DOM.buttonAlbum.onclick = () => getAlbum(DOM.inputFindAlbum.value);
//   DOM.buttonSize.onclick = () => getSize(DOM.inputFindSize.value);