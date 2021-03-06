import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/home",
    name: "Home",
    component: Home
  },
  {
    path: "/about",
    name: "About",
    component: () => import("../views/About.vue")
  },
  {
    path: "/",
    name: "Tool",
    component: () => import("../views/tool/index.vue")
  },
  {
    path: "/image",
    name: "Image",
    component: () => import("../views/image/index.vue")
  },
  {
    path: "/gen/edit",
    name: "editTable",
    component: () => import("../views/tool/editTable.vue")
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
