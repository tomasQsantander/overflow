var app = new Vue({
    el:"#app",
    data:{
        questions: {},
        errorToats: null,
        errorMsg: null,
        user: {}
    },
    methods:{
        getData: function(){
            axios.get("/api/questions")
            .then((response) => {
                //get questions info
                this.questions = response.data;
                axios.get("/api/current").then((response) => {
                     //get user info
                    this.user = response.data
                    }).catch((error)=>{
                          // handle error
                          this.errorMsg = "Error getting data";
                          this.errorToats.show();
                      })
            })
            .catch((error)=>{
                // handle error
                this.errorMsg = "Error getting data";
                this.errorToats.show();
            })
        },
        formatDate: function(date){
            return new Date(date).toLocaleDateString('en-gb');
        },

        create: function(){
            axios.post('http://localhost:8080/api/clients/current/accounts')
            .then(response => window.location.reload())
            .catch((error) =>{
                this.errorMsg = error.response.data;  
                this.errorToats.show();
            })
        },
        tagsFormat: function(tags){
            tags =  tags.map( tag => tag.subject);
            //return tags.join(", ");
            return tags;
        }
    },

    mounted: function(){
        this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
        this.getData();
    }
})
