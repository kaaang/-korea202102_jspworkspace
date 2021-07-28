<%@ page contentType="text/html;charset=UTF-8"%>
    <div class="catagories-side-menu">
        <!-- Close Icon -->
        <div id="sideMenuClose">
            <i class="ti-close"></i>
        </div>
        <!--  Side Nav  -->
        <div class="nav-side-menu">
            <div class="menu-list">
                <h6>Categories</h6>
                <ul id="menu-content" class="menu-content collapse out">

                    <!-- Single Item -->
                    <%for(int i=0;i<topList.size();i++){ %>
                    <%TopCategory topCategory = topList.get(i); %>
                    <li data-toggle="collapse" data-target="#women" class="collapsed active">
                        <a href="#"><%=topCategory.getTop_name() %> <span class="arrow"></span></a>
                        <ul class="sub-menu collapse" id="women">
                            <li><a href="#">Midi Dresses</a></li>
                            <li><a href="#">Maxi Dresses</a></li>
                            <li><a href="#">Prom Dresses</a></li>
                            <li><a href="#">Little Black Dresses</a></li>
                            <li><a href="#">Mini Dresses</a></li>
                        </ul>
                    </li>
					<%} %>
                </ul>
            </div>
        </div>
    </div>