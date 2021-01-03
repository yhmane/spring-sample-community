$(function () {

    var freeboard = {
        init : function () {
            var _this = this;

            var requestBody = {
                "pageNumber" :0,
                "pageSize": 10,
                "sort": "id",
                "direction": "desc"
            }

            _this.list(requestBody);
        },
        list : function(requestBody) {

            var pageNumber = requestBody.pageNumber;
            var pageSize = requestBody.pageSize;
            var sort = requestBody.sort;
            var direction = requestBody.direction;

            $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: `/api/v1/freeboard?pageNumber=${pageNumber}&pageSize=${pageSize}&sort=${sort}&direction=${direction}`,
                success: function (data) {
                    var _freeboardTbody = $('#freeboard').find('[name=freeboardTbody]');
                    var _freeboardPagnav = $('#freeboard').find('[name=freeboardPagnav]');

                    var result = data.data;
                    _freeboardTbody[0].innerHTML = "";
                    result.content.forEach(function(data, index) {
                        var str = `<tr><th scope="row">` + data.id + `</th><td>` + data.title + `</td><td>` + data.writer +`</td><td>` + data.updatedAt +`</td></tr>`
                        _freeboardTbody.append(str);
                    });

                    var curPage = result.number + 1;
                    var pageBlock = result.size;
                    var tot = result.totalElements;
                    var totalPages = result.totalPages;
                    var firstPage = parseInt(curPage / pageBlock, 10) * pageBlock + 1;
                    var prevPage = firstPage - 1 <= 1 ? 1 : firstPage - 1 ;
                    var lastPage = (parseInt(curPage / pageBlock, 10) + 1) * pageBlock >= totalPages ? totalPages : (parseInt(curPage / pageBlock, 10) + 1) * pageBlock;
                    var nextPage = lastPage + 1 >= totalPages ? totalPages : lastPage + 1;

                    _freeboardPagnav[0].innerHTML = "";
                    _freeboardPagnav.append('<li class="page-item"><a class="page-link" href="#" name="freeboardPage" data-page="1"><<</a></li>');
                    _freeboardPagnav.append('<li class="page-item"><a class="page-link" href="#" name="freeboardPage" data-page="' + prevPage +'">이전</a></li>');
                    for (var i = firstPage; i <= lastPage; i++) {
                        _freeboardPagnav.append('<li class="page-item"><a class="page-link" href="#" name="freeboardPage" data-page="' + i + '">' + i +'</a></li>');
                    }
                    _freeboardPagnav.append('<li class="page-item"><a class="page-link" href="#" name="freeboardPage" data-page="' + nextPage +'">다음</a></li>');
                    _freeboardPagnav.append('<li class="page-item"><a class="page-link" href="#" name="freeboardPage" data-page="' + totalPages + '">>></a></li>');
                    freeboard.pageEvent();
                }, error:function(request,status,error){
                }
            });
        },
        pageEvent : function() {
            $('#freeboard').find('[name=freeboardPage]').on('click', function (e) {
                var requestBody = {
                    "pageNumber" : Number(e.target.dataset.page) - 1,
                    "pageSize": 10,
                    "sort": "id",
                    "direction": "desc"
                }
                freeboard.list(requestBody);
            });
        }
    };

    freeboard.init();
});

