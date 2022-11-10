var app = new Vue({
    el:"#app",
    data:{
        errorToats: null,
        errorMsg: null,
        title:"",
        question:"",
        tags:""
    },
    methods:{
        formatDate: function(date){
            return new Date(date).toLocaleDateString('en-gb');
        },
        signOut: function(){
            axios.post('/api/logout')
            .then(response => window.location.href="/web/index.html")
            .catch(() =>{
                this.errorMsg = "Sign out failed"   
                this.errorToats.show();
            })
        },
        create: function(event){
            event.preventDefault();
            axios.post('/api/questions/new', `title=${this.title}&question=${this.question}&tags=${this.tags}`)
            .then(response => window.location.href = "/web/questions.html")
            .catch((error) =>{
                this.errorMsg = error.response.data;
                this.errorToats.show();
            })
           }
    },
    mounted: function(){
        this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
    }
})