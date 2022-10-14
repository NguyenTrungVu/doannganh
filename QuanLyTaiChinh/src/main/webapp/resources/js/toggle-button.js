/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


(function($) {
  'use strict';

  $(document).ready(() => {

    $("input[type='button']").click((event) => {
      $("input[type='button']").toggleClass("btn-toggle");
    });

  });

})(jQuery);