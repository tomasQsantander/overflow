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
            }).catch((error)=>{
                  // handle error
                  this.errorMsg = "Error getting data";
                  this.errorToats.show();
              })
        },
  }
  })