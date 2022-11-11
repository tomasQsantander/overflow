var app = new Vue({
    el:"#app",
    data:{
        errorToats: null,
        errorMsg: null,
        users: {},
        user: {}
    },
    mounted: function(){
         this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
         this.getData();
     },
    methods:{
        getData: function(){
        const urlParams = new URLSearchParams(window.location.search);
        const top = urlParams.get('top');
        let url="/api/ranking";
        if(top){
        url="/api/ranking/top";
        }
        axios.get(url).then((response) => {
                  //get user info
                    this.users = response.data;
                    axios.get("/api/current").then((response) => {
                     //get user info
                    this.user = response.data
                    console.log(this.user)
                    }).catch((error)=>{
                          // handle error
                          this.errorMsg = "Error getting data";
                          this.errorToats.show();
                      })
                })
                .catch((error) => {
                    // handle error
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                })
        },
  }
  })