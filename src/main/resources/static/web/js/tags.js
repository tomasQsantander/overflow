var app = new Vue({
    el:"#app",
    data:{
        errorToats: null,
        errorMsg: null,
        user:{},
        tags:{}
    },
    mounted: function(){
         this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
         this.getData();
     },
    methods:{
        getData: function(){
        axios.get("/api/current").then((response) => {
             //get user info
            this.user = response.data
            axios.get("/api/tag").then((response) => {
                this.tags = response.data
                }).catch((error)=>{
                    // handle error
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                })
            }).catch((error)=>{
                  // handle error
                  this.errorMsg = "Error getting data";
                  this.errorToats.show();
              })
        },
        tagsFormat: function(tags){
            tags =  tags.map( tag => tag.subject);
            //return tags.join(", ");
            return tags;
        },

       redirectTag: function(tag){
            window.location.href="http://localhost:8080/web/tag.html?subject="+tag;
       }
  }
  })