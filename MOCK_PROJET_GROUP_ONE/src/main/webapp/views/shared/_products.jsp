<%@taglib prefix="s" uri="/struts-tags" %>
<%@page isELIgnored="false" %>
<main id="site-main">
	<!-- begin wrapper-container -->
	<div class="container wrapper-container">

		<!--begin wrapper-container__menu-->
		<div class="row wrapper-container__menu " >
			<div class="col-12 d-flex justify-content-center ">
				<ul class="nav">
					<li class="nav-item">
						<a class="nav-link " href="#">Home</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Products</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Apple</a>
							<a class="dropdown-item" href="#">BPhone</a>
							<a class="dropdown-item" href="#">Huawei</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Separated link</a>
						</div>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Services</a>
					</li>
					<li class="nav-item">
						<a class="nav-link " href="#">Contact</a>
					</li>
					<li class="nav-item">
						<a class="nav-link " href="#">Help</a>
					</li>
				</ul>
			</div> 
		</div> 
		<!--end wrapper-container__menu-->				

		<!-- begin site-carousel -->
		<div class="row site-carousel bg-dark">
			<div class="col-12">
				<div id="site-carousel_content" class="carousel slide " data-ride="carousel">
				  <ol class="carousel-indicators">
				    <li data-target="#site-carousel_content" data-slide-to="0" class="active"></li>
				    <li data-target="#site-carousel_content" data-slide-to="1"></li>
				    <li data-target="#site-carousel_content" data-slide-to="2"></li>
				  </ol>
				  <div class="carousel-inner">
				    <div class="carousel-item active ">
				      <img class="d-block mx-auto" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/iphone-x-256gb-h2-400x460-400x460.png" alt="First slide">
				      <div class="carousel-caption d-none d-md-block">
				          <h5>Iphone XI - The next generation of Nokia</h5>
				          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Suscipit, quibusdam.</p>
				          <a href="#" class="btn  site-carousel__button--cta">View details</a>
				       </div>
				    </div>
				    <div class="carousel-item">
				      <img class="d-block mx-auto" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/oppo-f9-red-2-400x460.png" alt="Second slide">
				      <div class="carousel-caption d-none d-md-block">
				         <h5>Iphone XI - The next generation of Nokia</h5>
				          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Suscipit, quibusdam.</p>
				          <a href="#" class="btn  site-carousel__button--cta">View details</a>
				       </div>
				    </div>
				    <div class="carousel-item">
				      <img class="d-block mx-auto" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/bphone-2017-gold-400x460.png" alt="Third slide">
				      <div class="carousel-caption d-none d-md-block">
				          <h5>Iphone XI - The next generation of Nokia</h5>
				          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Suscipit, quibusdam.</p>
				          <a href="#" class="btn  site-carousel__button--cta">View details</a>
				       </div>
				    </div>
				  </div>
				  <a class="carousel-control-prev" href="#site-carousel_content" role="button" data-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="sr-only">Previous</span>
				  </a>
				  <a class="carousel-control-next" href="#site-carousel_content" role="button" data-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
				  </a>
				</div>
			</div>
		</div>
		<!-- End site-carousel -->
		
		<!-- begin products content -->					
	
		<div class="row mobile-trending-row">
			<h3 class="mobile-trending-row-title title--orange">Trending mobile</h3>
			<div id="mobile-trending-row-body" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators">
			    <li data-target="#mobile-trending-row-body" data-slide-to="0" class="active"></li>
			    <li data-target="#mobile-trending-row-body" data-slide-to="1"></li>
			    <li data-target="#mobile-trending-row-body" data-slide-to="2"></li>
			  </ol>
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			     
					<div class="row weshop-mobiles ">					
						<div class="col-3">
							<div class="card mobile-item text-center ">
								  <img class="card-img-top mobile-item__thumbnail" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/oppo-f9-red-2-400x460.png" alt="mobile image">
								  <div class="card-body mobile-item__price ">
								  	<p class="mobile-item__name mb-0">Opp F9</p>
								    <p class="mobile-item__price-value">
								    	<span class="mobile-item__price--past">$600 </span> <span class="mobile-item__price--discount">(-10%)</span>
								    </p>
									<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
									<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>

								  </div>
								<img class="d-block mobile-item--hightlight" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/sale.svg" alt="">
							  
							</div>
						</div>
						<div class="col-3">
							<div class="card mobile-item text-center ">
								  <img class="card-img-top mobile-item__thumbnail" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/iphone-x-64gb-1-400x460.png" alt="mobile image">
								  <div class="card-body mobile-item__price ">
								  	<p class="mobile-item__name mb-0">Iphone X - 64GB</p>
								    <p class="mobile-item__price-value">
								    	<span class="mobile-item__price--past">$1700 </span> <span class="mobile-item__price--discount">(-10%)</span>
								    </p>
									<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
									<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>

								  </div>
								<img class="d-block mobile-item--hightlight" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/sale.svg" alt="">
							  
							</div>
						</div>
						<div class="col-3">
							<div class="card mobile-item text-center ">
								  <img class="card-img-top mobile-item__thumbnail" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/iphone-6s-plus-32gb-400x450-400x450.png" alt="mobile image">
								  <div class="card-body mobile-item__price ">
								  	<p class="mobile-item__name mb-0">Iphone 6 - 64GB</p>
								    <p class="mobile-item__price-value">
								    	<span class="mobile-item__price--past">$1700 </span> <span class="mobile-item__price--discount">(-10%)</span>
								    </p>
									<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
									<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>

								  </div>
								<img class="d-block mobile-item--hightlight" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/sale.svg" alt="">
							  
							</div>
						</div>
						<div class="col-3">
							<div class="card mobile-item text-center ">
								  <img class="card-img-top mobile-item__thumbnail" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/samsung-galaxy-note-9-black-400x460-400x460.png" alt="mobile image">
								  <div class="card-body mobile-item__price ">
								  	<p class="mobile-item__name mb-0">Iphone 6 - 64GB</p>
								    <p class="mobile-item__price-value">
								    	<span class="mobile-item__price--past">$1700 </span> <span class="mobile-item__price--discount">(-10%)</span>
								    </p>
									<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
									<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>

								  </div>
								<img class="d-block mobile-item--hightlight" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/sale.svg" alt="">
							  
							</div>
						</div>						
						
					</div>

			    </div>
			    <div class="carousel-item">
			     	<div class="row weshop-mobiles ">					
			     		<div class="col-3">
			     			<div class="card mobile-item text-center ">
			     				  <img class="card-img-top mobile-item__thumbnail" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/oppo-f9-red-2-400x460.png" alt="mobile image">
			     				  <div class="card-body mobile-item__price ">
			     				  	<p class="mobile-item__name mb-0">Opp F9</p>
			     				    <p class="mobile-item__price-value">
			     				    	<span class="mobile-item__price--past">$600 </span> <span class="mobile-item__price--discount">(-10%)</span>
			     				    </p>
			     					<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
			     					<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>

			     				  </div>
			     				<img class="d-block mobile-item--hightlight" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/sale.svg" alt="">
			     			  
			     			</div>
			     		</div>
			     		<div class="col-3">
			     			<div class="card mobile-item text-center ">
			     				  <img class="card-img-top mobile-item__thumbnail" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/iphone-x-64gb-1-400x460.png" alt="mobile image">
			     				  <div class="card-body mobile-item__price ">
			     				  	<p class="mobile-item__name mb-0">Iphone X - 64GB</p>
			     				    <p class="mobile-item__price-value">
			     				    	<span class="mobile-item__price--past">$1700 </span> <span class="mobile-item__price--discount">(-10%)</span>
			     				    </p>
			     					<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
			     					<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>

			     				  </div>
			     				<img class="d-block mobile-item--hightlight" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/sale.svg" alt="">
			     			  
			     			</div>
			     		</div>
			     		<div class="col-3">
			     			<div class="card mobile-item text-center ">
			     				  <img class="card-img-top mobile-item__thumbnail" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/iphone-6s-plus-32gb-400x450-400x450.png" alt="mobile image">
			     				  <div class="card-body mobile-item__price ">
			     				  	<p class="mobile-item__name mb-0">Iphone 6 - 64GB</p>
			     				    <p class="mobile-item__price-value">
			     				    	<span class="mobile-item__price--past">$1700 </span> <span class="mobile-item__price--discount">(-10%)</span>
			     				    </p>
			     					<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
			     					<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>

			     				  </div>
			     				<img class="d-block mobile-item--hightlight" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/sale.svg" alt="">
			     			  
			     			</div>
			     		</div>
			     		<div class="col-3">
			     			<div class="card mobile-item text-center ">
			     				  <img class="card-img-top mobile-item__thumbnail" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/samsung-galaxy-note-9-black-400x460-400x460.png" alt="mobile image">
			     				  <div class="card-body mobile-item__price ">
			     				  	<p class="mobile-item__name mb-0">Iphone 6 - 64GB</p>
			     				    <p class="mobile-item__price-value">
			     				    	<span class="mobile-item__price--past">$1700 </span> <span class="mobile-item__price--discount">(-10%)</span>
			     				    </p>
			     					<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
			     					<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>

			     				  </div>
			     				<img class="d-block mobile-item--hightlight" src="<%=request.getServletContext().getContextPath()%>/views/assets/images/sale.svg" alt="">
			     			  
			     			</div>
			     		</div>						
			     		
			     	</div>
			    </div>
			   
			  </div>
			  <a class="carousel-control-prev" href="#mobile-trending-row-body role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#mobile-trending-row-body role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
		<!-- end mobile-trending-row -->

		<!-- begin top mobile brand -->
		<div class="row top-brand-row  justify-content-center">					
			<div class=" brand bg-dark">
				<a href="#" class="brand-link"><img src="<%=request.getServletContext().getContextPath()%>/views/assets/images/iphone-logo.jpg" alt="Iphone logo"></a>
				<a href="#" class="brand-link"><img src="<%=request.getServletContext().getContextPath()%>/views/assets/images/samsung-logo.jpg" alt="samsung logo"></a>
				<a href="#" class="logo-link"><img src="<%=request.getServletContext().getContextPath()%>/views/assets/images/oppo-logo.jpg" alt="oppo logo"></a>
				<a href="#" class="logo-link"><img src="<%=request.getServletContext().getContextPath()%>/views/assets/images/nokia-logo.jpg" alt="nokia logo"></a>
				<a href="#" class="logo-link"><img src="<%=request.getServletContext().getContextPath()%>/views/assets/images/vivo-logo.jpg" alt="vivo logo"></a>
			</div>
		</div>
		
		<!-- end top mobile brand -->

		<!-- begin all products -->
		
		<!-- begin pagination -->
		<div class="row pagination-row justify-content-between mt-3">
			<h3 class="pagination-row__title title--orange">All mobile</h3>
			<nav aria-label="product list pagination">
			  <ul class="pagination product-pagination">
			  
			    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
			    
			    <s:if test="%{maxNavigationTab > 4}">
			    	<li class="page-item"><a class="page-link" href="?page=1">1</a></li>
			    	<li class="page-item"><a class="page-link" href="?page=2">2</a></li>
			    	<li class="page-item"><a class="page-link" href="#">...</a></li>
			    	<li class="page-item"><a class="page-link" href="?page=<s:property value="maxNavigationTab"/>"> <s:property value="maxNavigationTab" /></a></li>
			    </s:if>
			    <s:else>
			    	  <s:iterator  begin="1" end="maxNavigationTab">
			    		<li class="page-item"><a class="page-link" href="?page=<s:property value="top"/>"> <s:property value="top" /></a></li>
			    	  </s:iterator>
			    </s:else>	    
			   
			    <li class="page-item"><a class="page-link" href="#">Next</a></li>
			  </ul>
			</nav>

		</div>
		<!-- end pagination -->
		
		<div class="row weshop-mobiles ">	

			<s:if test="%{products.size == 0}">
				<h3>Product page index <s:property value="page"/> has been update...</h3>
			</s:if>
			<s:else>
				<s:iterator value="products" > 
				<div class="col-sm-2">
					<div class="card mobile-item text-center ">
						  <a href="productDetail?id=<s:property value="id"/>"><img class="card-img-top mobile-item__thumbnail" src="/images/<s:property value="imageUrl"/>" alt="mobile image"/></a>
						  <div class="card-body mobile-item__price ">
						  	<p class="mobile-item__name mb-0"><s:property value="name"/> </p>
						    <p class="mobile-item__price-value">
						    	<span class="mobile-item__price--past"><s:property value="price"/> </span> <span class="mobile-item__price--discount">(-10%)</span>
						    </p>
							<p class="mobile-item__price-value mobile-item__price--promo">$550</p>
							<button class="btn btn-warning text-light w-50"><i class="fa fa-cart-plus" style="font-size: 1.3rem"></i></button>
	
						  </div>
						<img class="d-block mobile-item--hightlight" src="assets/images/sale.svg" alt="">
					  
					</div>
			</div>
			
			</s:iterator>		
			
			</s:else>
										
			
		</div>
		<hr>
		
		<!-- end all products -->
	<hr>
	</div>
	<!-- End wrapper-container -->

</main> <!-- End main -->