<template>
    <div>
        <el-upload
                class="upload-demo"
                drag
                action="http://localhost:8991/image/upload"
                multiple
                :show-file-list="false"
                :on-success="handleSuccess">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
        <div style="margin: 100px 0">
            <el-input ref="copyContent" v-model="imageURL" :readonly="true"><el-button @click="copy" slot="append" icon="el-icon-document-copy"></el-button></el-input>
        </div>
    </div>
</template>

<script>
    export default {
        name: "index",
        data() {
            return {
                imageURL: ''
            }
        },
        methods: {
            handleSuccess(response) {
                if (response.code == 200) {
                    this.imageURL = response.data
                }
            },
            copy() {
                this.$refs.copyContent.select();
                document.execCommand('copy');
            }
        }
    }
</script>

<style scoped>

</style>